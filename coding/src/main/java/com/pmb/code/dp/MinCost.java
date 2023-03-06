package com.pmb.code.dp;

/**
 * @author lvrui
 */
public class MinCost {
    public int minCost(int[][] costs) {
        int cost = 0 ;
        if(costs == null || costs.length == 0){
            return cost;
        }

        int n = costs.length;
        int dp[] = new int[3*n];
        dp[0] = costs[0][0];
        dp[1] = costs[0][1];
        dp[2] = costs[0][2];


        for(int i = 1;i<n;i++){
            dp[i*3] = Math.min(dp[i*3-2],dp[i*3-1])+costs[i][0];
            dp[i*3+1] = Math.min(dp[i*3-1],dp[i*3-3])+costs[i][1];
            dp[i*3+2] = Math.min(dp[i*3-2],dp[i*3-3])+costs[i][2];
        }

        return Math.min(Math.min(dp[3*n-3],dp[3*n-2]),dp[3*n-1]);
    }
}
