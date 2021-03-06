package com.pmb.code.dp;

import java.util.Arrays;

/**
 * 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * <p>
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * @author lvrui
 */
public class Rob {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = Arrays.copyOf(nums, nums.length);
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i] + dp[i - 2], dp[i - 1]);
        }


        return dp[nums.length - 1];
    }

    public int getCount(int n) {
        int res = 0;
        while (n != 0) {
            if (n % 10 == 1) {
                res++;
            }
            n = n / 10;
        }
        return res;
    }

    public String getN(String a) {
        StringBuilder sb = new StringBuilder();
        if (a == null || a.isEmpty()) {
            return sb.toString();
        }
        char[] temp = a.toCharArray();
        int count = 0;
        char pre = temp[0],current = temp[0];
        for (char entry : temp) {
            current = entry;
            if (pre == entry) {
                count++;
            } else {
                sb.append(count);
                sb.append(pre);
                count=1;
                pre = entry;
            }
        }
        sb.append(count).append(current);
        return sb.toString();
    }

    public static void main(String[] args) {
        Rob rob = new Rob();

        String count = rob.getN("skkkkks");
        rob.rob(new int[]{1, 2, 3, 1});
    }
}
