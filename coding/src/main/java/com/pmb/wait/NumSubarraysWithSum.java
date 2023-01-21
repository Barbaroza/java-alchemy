package com.pmb.wait;

import java.util.HashMap;
import java.util.Map;

/**
 * 930. 和相同的二元子数组
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * <p>
 * 子数组 是数组的一段连续部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * nums[i] 不是 0 就是 1
 * 0 <= goal <= nums.length
 * 通过次数21,236提交次数40,347
 *
 * @author lvrui
 */
public class NumSubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        if (goal < 0) {
            return res;
        }

        int curSum = 0;
        int start = 0;
        for (int index = 0; index < nums.length; index++) {
            curSum += nums[index];
            if (curSum == goal) {
                int sufCnt = 1;
                while (index + 1 < nums.length) {
                    if (nums[index + 1] == 0) {
                        sufCnt++;
                        index++;
                    } else {
                        break;
                    }
                }
                int preCnt = 1;
                while (start <= index) {
                    if (nums[start] == 0) {
                        preCnt++;
                        start++;
                    } else {
                        break;
                    }
                }
                res = res + (preCnt * sufCnt);
            }
            if (curSum > goal) {
                while (start <= index) {
                    if (nums[start] == 1 && curSum > goal) {
                        start++;
                        res++;
                        curSum--;
                    }
                    if (nums[start] == 0 && curSum == goal) {
                        start++;
                        res++;
                        continue;
                    }
                    if (curSum == goal) {
                        break;
                    }
                }
            }
        }

        return res;

    }
    public int numSubarraysWithSum2(int[] nums, int goal) {
        int n = nums.length;
        int left1 = 0, left2 = 0, right = 0;
        int sum1 = 0, sum2 = 0;
        int ret = 0;
        while (right < n) {
            sum1 += nums[right];
            while (left1 <= right && sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }
            sum2 += nums[right];
            while (left2 <= right && sum2 >= goal) {
                sum2 -= nums[left2];
                left2++;
            }
            ret += left2 - left1;
            right++;
        }
        return ret;
    }
    public int numSubarraysWithSum3(int[] nums, int goal) {
        int sum = 0;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        int ret = 0;
        for (int num : nums) {
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            sum += num;
            ret += cnt.getOrDefault(sum - goal, 0);
        }
        return ret;
    }



    public static void main(String[] args) {
        NumSubarraysWithSum numSubarraysWithSum = new NumSubarraysWithSum();
        int i = numSubarraysWithSum.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0);
    }
}
