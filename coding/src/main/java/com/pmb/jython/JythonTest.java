package com.pmb.jython;

import org.python.core.PyDictionary;
import org.python.core.PyFunction;
import org.python.util.PythonInterpreter;

import java.io.InputStream;
import java.util.*;

/**
 * @author lvrui
 */
public class JythonTest {

    public static void main(String[] args) {
            pythonCall(convert(mock()));

    }


    private static PyDictionary pythonCall(PyDictionary input) {

        System.out.println("ShippingOrderDispatcher.pythonCall params:{}" + input.toString());

        PyDictionary output = null;
        System.getProperty("user.dir");

        try (PythonInterpreter interpreter = new PythonInterpreter();
             InputStream resourceAsStream = JythonTest.class.getResourceAsStream("/algorithm/dispatcherv2.py");) {
            interpreter.execfile(resourceAsStream);
            PyFunction pyFunction = interpreter.get("get_information", PyFunction.class);
            output = (PyDictionary) pyFunction.__call__(input);

            PyDictionary car_1;
            //get(车id)
            car_1 = (PyDictionary) output.get(0);
            //增量
            System.out.println(car_1.get("push_list").getClass());
            System.out.println(car_1.get("pop_list").getClass());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ShippingOrderDispatcher.pythonCall error" + e.getMessage());
        }
        System.out.println("ShippingOrderDispatcher.pythonCall res:{}" + (output == null ? "null" : output.toString()));

        return output;
    }


    private static AlgorithmInputDTO mock() {
        List<AlgorithmRouteDTO> routes = new ArrayList<>();
        List<AlgorithmOrderDTO> orders = new ArrayList<>();
        List<AlgorithmCarDTO> cars = new ArrayList<>();

        AlgorithmInputDTO inputs = new AlgorithmInputDTO();
        inputs.setCars(cars);
        inputs.setRoutes(routes);
        inputs.setOrders(orders);

        AlgorithmRouteDTO route1 = new AlgorithmRouteDTO();
        route1.setId(1);
        List<Long> route_node = Arrays.asList(0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L);
        route1.setNode(route_node);
        List<Integer> route_interval = Arrays.asList(1, 1, 1, 2, 1, 1, 3, 2, 2);
        route1.setInterval(route_interval);
        routes.add(route1);

        Random random = new Random();
        for (int ii = 0; ii < 100; ii++) {
            AlgorithmOrderDTO order = new AlgorithmOrderDTO();
            long order_id;
            order_id = ii;
            int capacity1 = random.nextInt(6) + 5;
            int start1 = random.nextInt(9);
            int end1 = random.nextInt(9);
            if (end1 <= start1) {
                end1 = start1 + 1;
            }
            Integer startNode = start1;
            Integer endNode = end1;

            long times = System.currentTimeMillis();
            double scores = Math.random();
            int score;
            if (scores >= 0.9) {
                score = 1000;
            } else if (scores >= 0.6) {
                score = 500;
            } else {
                score = capacity1;
            }
            order.setCapacity(capacity1);
            order.setCreate_time(times);
            order.setScore(score);
            order.setCapacity(capacity1);
            order.setId(order_id);
            order.setEnd(endNode);
            order.setStart(startNode);
            orders.add(order);
        }


        for (int ii = 0; ii < 10; ii++) {
            AlgorithmCarDTO car = new AlgorithmCarDTO();
            car.setCapacity(50);
            car.setMax_capacity(50);
            long car_id;
            car_id = ii;
            car.setId(car_id);
            car.setRoute(1L);
            car.setLocation(0L);
            cars.add(car);
        }

        return inputs;
    }

    private static PyDictionary convert(AlgorithmInputDTO inputs) {
        PyDictionary route = new PyDictionary();
        PyDictionary order1 = new PyDictionary();
        PyDictionary car1 = new PyDictionary();

        List<AlgorithmOrderDTO> orders = inputs.getOrders();
        List<AlgorithmRouteDTO> routes = inputs.getRoutes();
        List<AlgorithmCarDTO> cars = inputs.getCars();

        for (AlgorithmRouteDTO algorithmRouteDTO : routes) {
            HashMap<Object, Object> routeinput = new HashMap<>();
            routeinput.put("node", algorithmRouteDTO.getNode());
            routeinput.put("interval", algorithmRouteDTO.getInterval());
            route.put(algorithmRouteDTO.getId(), routeinput);
        }

        for (AlgorithmOrderDTO algorithmOrderDTO : orders) {
            HashMap<Object, Object> orderinput = new HashMap<>();
            orderinput.put("capacity", algorithmOrderDTO.getCapacity());
            orderinput.put("start", algorithmOrderDTO.getStart());
            orderinput.put("score", algorithmOrderDTO.getScore());
            orderinput.put("end", algorithmOrderDTO.getEnd());
            orderinput.put("create_time", algorithmOrderDTO.getCreate_time());
            orderinput.put("load_time", algorithmOrderDTO.getLoad_time());
            order1.put(algorithmOrderDTO.getId(), orderinput);
        }

        for (AlgorithmCarDTO algorithmCarDTO : cars) {
            HashMap<Object, Object> carinput = new HashMap<>();
            carinput.put("capacity", algorithmCarDTO.getCapacity());
            carinput.put("max_capacity", algorithmCarDTO.getMax_capacity());
            carinput.put("location", algorithmCarDTO.getLocation());
            carinput.put("route", algorithmCarDTO.getRoute());
            carinput.put("matched_not_load_list", algorithmCarDTO.getMatched_not_load_order_list());
            carinput.put("load_order_list", algorithmCarDTO.getLoad_order_list());
            car1.put(algorithmCarDTO.getId(), carinput);
        }

        PyDictionary pydict = new PyDictionary();
        pydict.put("route_list", route);
        pydict.put("order_list", order1);
        pydict.put("car_list", car1);

        return pydict;
    }
}
