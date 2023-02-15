package com.pmb.wait_2023_02_02;

import java.util.Arrays;

/**
 * @author lvrui
 */
public class DPSolution {
    public String LCS(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        int max = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (dp[i + 1][j + 1] > max) {
                        max = dp[i + 1][j + 1];
                        index = i;
                    }
                }
            }
        }


        return max == Integer.MIN_VALUE ? "" : str1.substring(index - max + 1, index + 1);


    }

    public int editDistance(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();


        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 1; i <= l1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i <= l2; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }


        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                boolean curCost = str1.charAt(i - 1) == str2.charAt(j - 1);

                dp[i][j] = curCost ? dp[i - 1][j - 1] : Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }


        return dp[l1][l2];

    }

    public int rob(int[] nums) {
        int l1 = nums.length;

        int[] dp = new int[l1 + 1];
        dp[1] = nums[0];

        for (int i = 2; i <= l1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }


        return dp[l1];


    }


    public int rob2(int[] nums) {

        int l1 = nums.length;


        int[] dp = new int[l1 + 1];

        int max = Integer.MIN_VALUE;

        //s1

        dp[1] = nums[0];
        for (int i = 2; i <= l1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        max = dp[l1];
        //s2

        Arrays.fill(dp, 0);

        for (int i = 2; i <= l1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        max = Math.max(dp[l1], max);

        return max == Integer.MIN_VALUE ? 0 : max;
    }


    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            int cP = prices[i] - prices[i - 1];
            if (cP > 0) {
                profit += cP;
            }
        }

        return profit;
    }


    public int maxProfit3(int[] prices) {
        int n = prices.length;
        if (n == 1) return 0;
        int[][][] dp = new int[n][2][3];
        dp[0][0][1] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][0][2] = 0;
        dp[0][1][2] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
            dp[i][0][2] = Math.max(dp[i - 1][0][2], dp[i - 1][1][2] + prices[i]);
            dp[i][1][2] = Math.max(dp[i - 1][1][2], dp[i - 1][0][1] - prices[i]);
        }
        return dp[n - 1][0][2];
    }


    public int maxProfit4(int K, int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n][K + 1][2];

        for(int i =0;i<K;i++) {
            dp[0][i][1] = -prices[0];
        }
        for(int i=1;i<n;i++){
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][1] - prices[i]);
        }

        for(int i = 1;i<n;i++){
            for(int j =1;j<K;j++){
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
            }
        }
        Integer integer = Arrays.stream(new String[2]).map(String::length).min(Integer::compareTo).get(); int minLength = integer;

        return dp[n - 1][K][0];
    }



    }
