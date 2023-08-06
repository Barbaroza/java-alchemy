package com.pmb.wait.wait_2023_07;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author lvrui
 */
public class Week356 {


    public static void main(String[] args) {

    }

    //https://leetcode.cn/problems/count-complete-subarrays-in-an-array/
    public int countCompleteSubarrays(int[] nums) {
        int res = 0;

        Set<Integer> unique = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int r = 0;
        Set<Integer> window = new HashSet<>();
        for (int l = 0; l < nums.length; l++) {
            window.add(nums[l]);
            while (window.size() == unique.size()) {
                window.remove(nums[l]);
                l++;
                res += l;
            }
        }


        return res;
    }

    //https://leetcode.cn/problems/shortest-string-that-contains-three-strings/

    int[][] matrix = new int[][]{{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0, 1}, {2, 1, 0}};

    public String minimumString(String a, String b, String c) {


        String[] strArr = new String[]{a, b, c};
        PriorityQueue<String> queue = new PriorityQueue<String>((e1, e2) -> {
            return e1.length() == e2.length() ? e1.compareTo(e2) : e1.length() - e2.length();
        });

        for (int i = 0; i < matrix.length; i++) {

            queue.add(merge(merge(strArr[matrix[i][0]], strArr[matrix[i][1]]), strArr[matrix[i][2]]));
        }

        return queue.peek();
    }

    private String merge(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        int min = Math.min(aLength, bLength);
        int index = 0;
        for (int i = 0; i < min; i++) {
            if (a.charAt(aLength--) == b.charAt(i)) {
                index = i;
            } else {
                break;
            }
        }

        return a.substring(0, aLength - index) + b.substring(index, b.length());

    }

}
