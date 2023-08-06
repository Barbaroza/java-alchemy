package com.pmb.wait.wait_2023_02_02;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author lvrui
 */
public class HashSolution {
    public int[] FindNumsAppearOnce(int[] array) {

        int tmp = 0;
        for (int num : array) {
            tmp ^= num;
        }

        int mask = 1;
        while ((tmp & mask) == 0) {
            mask <<= 1;
        }

        int a = 0;
        int b = 0;
        for (int num : array) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        if (a > b) {
            int c = a;
            a = b;
            b = c;
        }
        return new int[]{a, b};
    }


    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (num == null || num.length < 3) {
            return ans;
        }

        Arrays.sort(num);

        for (int i = 0; i < num.length - 2; i++) {
            if (num[i] > 0) {
                break;
            }

            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }

            int l = i + 1, r = num.length - 1;
            while (l < r) {
                if (l > i + 1 && num[l] == num[l - 1]) {
                    l++;
                    continue;
                }

                int subAns = num[i] + num[l] + num[r];
                if (subAns == 0) {
                    ArrayList<Integer> tuple = new ArrayList<>();
                    tuple.add(num[i]);
                    tuple.add(num[l]);
                    tuple.add(num[r]);
                    ans.add(tuple);
                    l++;
                    r--;

                } else if (subAns < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }


        return ans;
    }
}
