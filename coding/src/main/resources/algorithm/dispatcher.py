# -*- coding: utf-8 -*-

import copy
import random
import time


class Route:
    def __init__(self, route):
        self.id = route[0]  # 路径id
        self.node = route[1]  # 路径节点信息
        self.node_nums = len(self.node)  # 路径节点个数
        self.interval = route[2]  # 路径节点间距离
        self.node_dict = {}  # 节点索引表
        self.length = sum(self.interval)  # 路径总长度
        for idx, x in enumerate(self.node):
            self.node_dict.setdefault(x, idx)


class Order:
    def __init__(self, idx, capacity, start, end, create_time, load_time, score=0):
        self.id = idx  # 订单id
        self.capacity = capacity  # 订单需求容量
        self.start = start  # 订单起始节点
        self.end = end  # 订单终节点
        self.score = score  # 订单优先级
        self.create_time = create_time  # 订单生成时间
        self.load_time = load_time  # 订单目标装车时间


class Car:
    def __init__(self, idx, capacity, max_capacity, load_order_list, matched_not_load_order_list, location, route):
        self.id = idx  # 车辆id
        self.capacity = capacity  # 车辆当前容量
        self.max_capacity = max_capacity  # 车辆最大容量
        self.load_order_list = load_order_list   # 车辆已装载订单列表
        self.matched_not_load_order_list = matched_not_load_order_list  # 车辆已匹配未装载订单列表，按优先级排序
        self.location = location  # 车辆节点位置
        self.capacity_list = []  # 车辆在每个节点的容量列表
        self.route = route
        self.init_capacity_list(route)
        self.push_list = []
        self.pop_list = []

    def init_capacity_list(self, route):   # 初始化节点容量表
        self.capacity_list = [self.capacity for _ in range(route.node_nums)]
        for order in self.load_order_list:
            for i in range(route.node_dict[order.end], route.node_nums):
                self.capacity_list[i] += order.capacity
        for order in self.matched_not_load_order_list:
            for i in range(route.node_dict[order.start], route.node_dict[order.end]):
                self.capacity_list[i] -= order.capacity

    def update_capacity_list(self, order, kind=0):   # 更新节点容量表， kind=0表示插入订单，kind=1表示删除订单
        if kind == 0:
            for i in range(self.route.node_dict[order.start], self.route.node_dict[order.end]):
                self.capacity_list[i] -= order.capacity
        else:
            for i in range(self.route.node_dict[order.start], self.route.node_dict[order.end]):
                self.capacity_list[i] += order.capacity


# routes = Route([1, ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'], [0.5, 0.6, 0.4, 0.5, 0.6, 0.5, 0.3, 0.6, 0.6]])


def score_compute(time_weight=0.5, capacity_weight=0.5):
    """

    :param time_weight: 时间权重，权重越大，下单越早的订单越先匹配
    :param capacity_weight: 容量权重，权重越大，需要容量越大的订单越先匹配
    :return: 订单按评分降序排序
    """
    order_dict = {}  # 订单字典，key:value 订单号：索引， 通过订单号查找在order_list中的索引
    # 按时间降序排序，越早生成的订单索引越大
    time_sort = sorted(order_list, key=lambda order: order.create_time, reverse=True)
    # 按容量需求升序排序，需求容量越大的订单索引越大
    capacity_sort = sorted(order_list, key=lambda order: order.capacity)
    for i in range(len(order_list)):
        order_dict.setdefault(order_list[i].id, i)
    for i in range(len(order_list)):
        time_order_id = order_dict[time_sort[i].id]
        order_list[time_order_id].score += i*time_weight   # 订单赋时间分
        capacity_order_id = order_dict[capacity_sort[i].id]
        order_list[capacity_order_id].score += i*capacity_weight  # 订单赋容量分
    order_list.sort(key=lambda order: order.score)


def matching(order, car_list, routes, distance_weight=0.5, capacity_use_weight=0.5):
    # for idx, order in enumerate(order_list):
    car_cost = []
    for idy, car in enumerate(car_list):  # 计算成本
        if routes.node_dict[order.start] < routes.node_dict[car.location]:   # 车辆已过订单位置
            car_cost.append(100000)
        elif min(car.capacity_list[routes.node_dict[order.start]:routes.node_dict[order.end]]) < order.capacity:
            # 车辆在订单起终点之间容量小于订单需求容量，计算抢占分
            cost = seize_scores(order, car)
            car_cost.append(cost)

        else:
            # 成本 = 距离权重*接单距离归一化+使用率权重*资源使用率归一化
            cost = distance_weight*(routes.node_dict[order.start]-routes.node_dict[car.location])/routes.node_nums + \
                   capacity_use_weight*(min(car.capacity_list[routes.node_dict[order.start]:routes.node_dict[order.end]])-order.capacity)/car.max_capacity
            car_cost.append(cost)
    if min(car_cost) < 5000:  # 直接分配
        print('car', car_list[car_cost.index(min(car_cost))].id, 'push order', order.id)
        car_list[car_cost.index(min(car_cost))].push_list.append(order.id)
        print('before update:', car_list[car_cost.index(min(car_cost))].capacity_list)
        car_list[car_cost.index(min(car_cost))].update_capacity_list(order)
        print('after update:', car_list[car_cost.index(min(car_cost))].capacity_list)
        return True
    elif 5000 <= min(car_cost) < 100000:   # 资源抢占
        # car = car_list[car_cost.index(min(car_cost))]
        car_list[car_cost.index(min(car_cost))] = seize(order, car_list[car_cost.index(min(car_cost))])
        return True
    else:
        return False  # 匹配失败


def not_capacity_index_find(order, car):
    capacity_list = car.capacity_list[routes.node_dict[order.start]:routes.node_dict[order.end]]
    index = []
    for capacity_index, capacity in enumerate(capacity_list):  # 统计未满足容量的节点索引
        if capacity >= order.capacity:
            pass
        else:
            index.append(capacity_index + order.capacity - capacity)
    return index


def seize_scores(order, car):
    car1 = copy.deepcopy(car)
    car1.matched_not_load_order_list.sort(key=lambda o: o.score)
    if not car1.matched_not_load_order_list:
        return 100000
    if car1.matched_not_load_order_list[0].score >= order.score:  # 订单优先级小于车辆已匹配未装载订单最小优先级，不能抢占
        return 100000
    else:
        i = 0
        index = not_capacity_index_find(order, car1)
        pop_order_score = 5000
        while i <= len(car1.matched_not_load_order_list)-1 and car1.matched_not_load_order_list[i].score < order.score:
            # 对已匹配未装载订单优先级从小到大进行pop
            car2 = copy.deepcopy(car1)
            car2.update_capacity_list(car1.matched_not_load_order_list[i], kind=1)  # 从已匹配未装载订单中删除，更新容量表
            index2 = not_capacity_index_find(order, car2)
            if not index2:  # 更新后满足要求
                pop_order_score += car2.matched_not_load_order_list[i].score
                return pop_order_score
            else:
                if index2 != index:  # 可用容量增大，向目标靠近
                    pop_order_score += car1.matched_not_load_order_list[i].score
                    car1.capacity_list = copy.deepcopy(car2.capacity_list)
                    index = copy.deepcopy(index2)
                else:
                    pass
            i += 1
        return 100000


def seize(order, car):  # 执行抢占
    car0 = copy.deepcopy(car)
    car0.matched_not_load_order_list.sort(key=lambda o: o.score)
    car1 = copy.deepcopy(car)
    car1.matched_not_load_order_list.sort(key=lambda o: o.score)
    index = not_capacity_index_find(order, car1)   # 不满足容量的站点索引表

    i = 0
    pop_list = []
    while car1.matched_not_load_order_list[i].score < order.score and i <= len(car1.matched_not_load_order_list) - 1:
        car2 = copy.deepcopy(car1)
        car2.update_capacity_list(car1.matched_not_load_order_list[i], kind=1)  # 从已匹配未装载订单中删除，更新容量表
        index2 = not_capacity_index_find(order, car2)  # 更新后不满足容量站点索引表
        if not index2:  # 为空表示都满足
            pop_list.append(i)
            break
        else:
            if index2 != index:  # 不一致表示删除有效
                pop_list.append(i)
                car1.capacity_list = copy.deepcopy(car2.capacity_list)
                index = copy.deepcopy(index2)
            else:
                pass
        i += 1
    pop_list.sort(reverse=True)
    for pop_index in pop_list:
        pop_order = car0.matched_not_load_order_list[pop_index]
        car0.matched_not_load_order_list.remove(pop_order)
        car0.pop_list.append(pop_order)
        car0.update_capacity_list(pop_order, kind=1)
        order_list.append(pop_order)
        print('car', car0.id, 'pop order', pop_order.id)
    car0.push_list.append(order.id)
    print('car', car0.id, 'push order', order.id)
    print('before update:', car0.capacity_list)
    car0.update_capacity_list(order)
    print('after update:', car0.capacity_list)
    return car0


def decode(dict):   # 对Java端输入进行解码，变成python能用的形式
    route_dict = dict['route_list']
    routes_list = []
    route_map = {}
    order_dict = dict['order_list']
    print(order_dict)
    order_list = []
    order_map = {}
    car_dict = dict['car_list']
    car_list = []
    car_map = {}
    for key in route_dict:
        route = Route([key, route_dict[key]['node'], route_dict[key]['interval']])
        routes_list.append(route)
        route_map.setdefault(key, route)
    for key in order_dict:
        order_inf = order_dict[key]
        order = Order(key, order_inf['capacity'], order_inf['start'], order_inf['end'], order_inf['create_time'], order_inf['load_time'], score=order_inf['score'])
        order_list.append(order)
        order_dict.setdefault(key, order)
    for key in car_dict:
        car = car_dict[key]
        car_route = route_map[car['route']]
        car_load_order_list = []
        if car['load_order_list']:
            for order in car['load_order_list']:
                car_load_order_list.append(order_map[order])
        car_matched_not_load_order_list = []
        if car['matched_not_load_list']:
            for order in car['matched_not_load_list']:
                car_matched_not_load_order_list.append(order_map[order])
        cars = Car(key, car['capacity'], car['max_capacity'], car_load_order_list, car_matched_not_load_order_list, car['location'], car_route)
        car_list.append(cars)
    return routes_list, order_list, car_list


def get_information(dict):
    print("Information from Java:", dict)
    print(type(dict))
    routes_list, order_list, car_list = decode(dict)
    order_list2 = copy.deepcopy(order_list)
    routes = routes_list[0]
    defeat_order = 0
    while order_list:
        # score_compute()
        order_list.sort(key=lambda order: order.score)
        order1 = order_list.pop()
        if matching(order1, car_list, routes, capacity_use_weight=-0.5):
            print(order1.id, 'match successful')
        else:
            defeat_order += 1
            print(order1.id, 'match lose')
    print(defeat_order)
    print('total capacity:', 50 * 10 * 9)
    now_use = [0 for i in range(10)]
    for car23 in car_list:
        print(car23.capacity_list)
        for i in range(10):
            now_use[i] += 50 - car23.capacity_list[i]
    print('use capacity:', now_use, sum(now_use))
    orders_sum = [0 for i in range(10)]
    print(routes.node_dict)
    for order2 in order_list2:
        for i in range(routes.node_dict[order2.start], routes.node_dict[order2.end]):
            orders_sum[i] += order2.capacity

    print('need capacity:', orders_sum, sum(orders_sum))
    max_use = [0 for i in range(10)]
    for i in range(10):
        if orders_sum[i] > 500:
            max_use[i] = 500
        else:
            max_use[i] = orders_sum[i]
    print('max use:', max_use)
    print('use rate:', sum(now_use) / sum(max_use))

    car_dict = {}
    for car in car_list:
        car_dict_dict = {}
        car_dict_dict.setdefault('push_list', car.push_list)
        car_dict_dict.setdefault('pop_list', car.pop_list)
        car_dict.setdefault(car.id, car_dict_dict)

    return car_dict

def matchinges():
    routes = Route(
        [1, ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'], [0.5, 0.6, 0.4, 0.5, 0.6, 0.5, 0.3, 0.6, 0.6]])
    nodes = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J']
    orders = []
    for ii in range(100):
        capacity1 = random.randint(5, 10)
        start1 = random.randint(0, 8)
        end1 = random.randint(start1 + 1, 9)
        start1 = nodes[start1]
        end1 = nodes[end1]
        times = time.time()
        scores = random.random()
        if scores >= 0.9:
            scores = 1000
        elif scores >= 0.6:
            scores = 500
        else:
            scores = capacity1
        orders.append(Order(ii, capacity1, start1, end1, times, score=scores))
    cars = []
    for ii in range(10):
        capacity1 = 50
        location1 = 'A'
        cars.append(Car(ii, capacity1, capacity1, [], [], location1, routes))
    for ii in range(10):
        cars[ii].matched_not_load_order_list.append(orders[5 * ii])
        cars[ii].update_capacity_list(orders[5 * ii])
        cars[ii].matched_not_load_order_list.append(orders[5 * ii + 1])
        cars[ii].update_capacity_list(orders[5 * ii + 1])
        cars[ii].matched_not_load_order_list.append(orders[5 * ii + 2])
        cars[ii].update_capacity_list(orders[5 * ii + 2])
        cars[ii].matched_not_load_order_list.append(orders[5 * ii + 3])
        cars[ii].update_capacity_list(orders[5 * ii + 3])
        cars[ii].matched_not_load_order_list.append(orders[5 * ii + 4])
        cars[ii].update_capacity_list(orders[5 * ii + 4])
    order_list = orders[50:]
    car_list = copy.deepcopy(cars)
    defeat_order = 0
    while order_list:
        # score_compute()
        order_list.sort(key=lambda order: order.score)
        order1 = order_list.pop()
        if matching(order1, car_list):
            print(order1.id, 'match successful')
        else:
            defeat_order += 1
            print(order1.id, 'match lose')
    print(defeat_order)
    print('total capacity:', 50 * 10 * 9)
    now_use = [0 for i in range(10)]
    for car23 in car_list:
        print(car23.capacity_list)
        for i in range(10):
            now_use[i] += 50 - car23.capacity_list[i]
    print('use capacity:', now_use, sum(now_use))
    orders_sum = [0 for i in range(10)]
    for order2 in orders:
        for i in range(routes.node_dict[order2.start], routes.node_dict[order2.end]):
            orders_sum[i] += order2.capacity

    print('need capacity:', orders_sum, sum(orders_sum))
    max_use = [0 for i in range(10)]
    for i in range(10):
        if orders_sum[i] > 500:
            max_use[i] = 500
        else:
            max_use[i] = orders_sum[i]
    print('max use:', max_use)
    print('use rate:', sum(now_use) / sum(max_use))

    car_dict = {}
    for car in car_list:
        car_dict_dict = {}
        car_dict_dict.setdefault('push_list', car.push_list)
        car_dict_dict.setdefault('pop_list', car.pop_list)
        car_dict.setdefault(car.id, car_dict_dict)

    return car_dict


if __name__ == '__main__':
    print("Welcome to Python!")