package com.pmb.wait_2023_01_02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lvrui
 */
public class AlternateDigitSum {
    public int alternateDigitSum(int n) {
        LinkedList<Integer> queue = new LinkedList<>();
        while (n > 0) {
            queue.addFirst(n % 10);
            n /= 10;
        }
        boolean switcher = true;
        int ans = 0;
        while (!queue.isEmpty()) {
            if (switcher) {
                ans += queue.poll();
            }else {
                ans -= queue.poll();

            }
            switcher = !switcher;
        }

        return ans;
    }

    public static void main(String[] args) {
        AlternateDigitSum alternateDigitSum = new AlternateDigitSum();
        alternateDigitSum.alternateDigitSum(10);
    }
}
