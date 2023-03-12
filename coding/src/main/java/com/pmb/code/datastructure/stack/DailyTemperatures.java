package com.pmb.code.datastructure.stack;

import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/iIQa4I/submissions/
 *
 * @author lvrui
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> deque = new LinkedList();
        int[] ans = new int[temperatures.length];


        for (int i = 0; i < temperatures.length; i++) {

            while (!deque.isEmpty() && temperatures[i] > temperatures[deque.getLast()]) {
                int pre = deque.removeLast();
                ans[pre] = i - pre;
            }
            deque.addLast(i);


        }


        return ans;


    }
}
