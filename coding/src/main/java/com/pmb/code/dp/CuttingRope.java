package com.pmb.code.dp;

/**
 * https://leetcode.cn/problems/jian-sheng-zi-lcof/
 */
public class CuttingRope {
    public int cuttingRope(int n) {
        int[] dp  = new int[n+1];
        dp[1] =1;
        dp[2]=1;

        for(int i =3 ;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }

        return dp[n];
    }
}
