package com.pmb.code.search.binary;

/**
 * https://leetcode.cn/problems/kLl5u1/
 *
 * @author lvrui
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];

        if (target > numbers[numbers.length - 1] * 2 || target < numbers[0] * 2) {
            //throw new Expcetion
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            int t = target - numbers[i];
            int b = binSearch(numbers, i + 1, numbers.length - 1, t);
            if (b != Integer.MIN_VALUE) {
                ans[0] = i;
                ans[1] = b;
                break;
            }
        }


        return ans;

    }

    private int binSearch(int[] numbers, int l, int r, int target) {
        while (l <= r) {
            int mid = r - ((r - l) >> 1);
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }


        return Integer.MIN_VALUE;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low, high};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
        TwoSum sum = new TwoSum();
        sum.twoSum(new int[]{1, 2, 4, 6, 10}, 8);
    }
}
