package com.pmb.code.datastructure.stack;

import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/XagZNi/
 *
 * @author lvrui
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> deque = new LinkedList<>();

        for (int num : asteroids) {
            boolean sign = true;
            while (sign && num < 0 && !deque.isEmpty() && deque.getLast() > 0) {
                int pre = deque.getLast();
                if (pre + num <= 0) {
                    deque.removeLast();
                }
                if (pre + num >= 0) {
                    sign = false;
                }
            }

            if (sign) {
                deque.addLast(num);
            }


        }

        int size = deque.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = deque.removeLast();
        }
        return ans;


    }
}
