package com.pmb.wait_2022_11;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/contest/weekly-contest-318/problems/total-cost-to-hire-k-workers/
 * 6231. 雇佣 K 位工人的总代价 显示英文描述
 * 通过的用户数1155
 * 尝试过的用户数1755
 * 用户总通过次数1176
 * 用户总提交次数3102
 * 题目难度Medium
 * 给你一个下标从 0 开始的整数数组 costs ，其中 costs[i] 是雇佣第 i 位工人的代价。
 * <p>
 * 同时给你两个整数 k 和 candidates 。我们想根据以下规则恰好雇佣 k 位工人：
 * <p>
 * 总共进行 k 轮雇佣，且每一轮恰好雇佣一位工人。
 * 在每一轮雇佣中，从最前面 candidates 和最后面 candidates 人中选出代价最小的一位工人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 * 比方说，costs = [3,2,7,7,1,2] 且 candidates = 2 ，第一轮雇佣中，我们选择第 4 位工人，因为他的代价最小 [3,2,7,7,1,2] 。
 * 第二轮雇佣，我们选择第 1 位工人，因为他们的代价与第 4 位工人一样都是最小代价，而且下标更小，[3,2,7,7,2] 。注意每一轮雇佣后，剩余工人的下标可能会发生变化。
 * 如果剩余员工数目不足 candidates 人，那么下一轮雇佣他们中代价最小的一人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 * 一位工人只能被选择一次。
 * 返回雇佣恰好 k 位工人的总代价。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
 * 输出：11
 * 解释：我们总共雇佣 3 位工人。总代价一开始为 0 。
 * - 第一轮雇佣，我们从 [17,12,10,2,7,2,11,20,8] 中选择。最小代价是 2 ，有两位工人，我们选择下标更小的一位工人，即第 3 位工人。总代价是 0 + 2 = 2 。
 * - 第二轮雇佣，我们从 [17,12,10,7,2,11,20,8] 中选择。最小代价是 2 ，下标为 4 ，总代价是 2 + 2 = 4 。
 * - 第三轮雇佣，我们从 [17,12,10,7,11,20,8] 中选择，最小代价是 7 ，下标为 3 ，总代价是 4 + 7 = 11 。注意下标为 3 的工人同时在最前面和最后面 4 位工人中。
 * 总雇佣代价是 11 。
 * 示例 2：
 * <p>
 * 输入：costs = [1,2,4,1], k = 3, candidates = 3
 * 输出：4
 * 解释：我们总共雇佣 3 位工人。总代价一开始为 0 。
 * - 第一轮雇佣，我们从 [1,2,4,1] 中选择。最小代价为 1 ，有两位工人，我们选择下标更小的一位工人，即第 0 位工人，总代价是 0 + 1 = 1 。注意，下标为 1 和 2 的工人同时在最前面和最后面 3 位工人中。
 * - 第二轮雇佣，我们从 [2,4,1] 中选择。最小代价为 1 ，下标为 2 ，总代价是 1 + 1 = 2 。
 * - 第三轮雇佣，少于 3 位工人，我们从剩余工人 [2,4] 中选择。最小代价是 2 ，下标为 0 。总代价为 2 + 2 = 4 。
 * 总雇佣代价是 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= costs.length <= 105
 * 1 <= costs[i] <= 105
 * 1 <= k, candidates <= costs.length
 *
 * @author lvrui
 */
public class TotalCost {

    class Node implements Comparable<Node> {
        int isLeft;
        int index;
        int value;

        public Node(int value, int index, int isLeft) {
            this.isLeft = isLeft;
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            if (value == o.value) {
                return Integer.compare(index, o.index);
            }
            return Integer.compare(value, o.value);
        }
    }

    public long totalCost(int[] costs, int k, int candidates) {
        int left = 0, right = costs.length - 1;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 0;i < candidates;i++) {
            if (left > right) {
                break;
            }
            queue.add(new Node(costs[left], left, 1));
            left++;
        }
        for (int i = 0;i < candidates;i++) {
            if (left > right) {
                break;
            }
            queue.add(new Node(costs[right], right, 0));
            right--;
        }
        long ret = 0;
        for (int i = 0;i < k;i++) {
            Node node = queue.poll();
            ret += node.value;
            if (left > right) {
                continue;
            }
            if (node.isLeft == 1) {
                queue.add(new Node(costs[left], left, 1));
                left++;
            } else {
                queue.add(new Node(costs[right], right, 0));
                right--;
            }
        }
        return ret;
    }
}
