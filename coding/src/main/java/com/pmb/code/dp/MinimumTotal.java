package com.pmb.code.dp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lvrui
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][] = new int[2][triangle.size()];

        Arrays.fill(dp[0],Integer.MAX_VALUE);
        Arrays.fill(dp[1],Integer.MAX_VALUE);
        dp[0][0] = triangle.get(0).get(0);

        for(int i = 1 ;i<triangle.size();i++){
            List<Integer> layer  =  triangle.get(i);
            int[] pre = dp[(i-1)%2];
            int[] cur = dp[i%2];
            for(int j =0 ;j<layer.size();j++){
                int val = layer.get(j);
                if(j == 0){
                    cur[j] = pre[j]+val;
                }else{
                    cur[j] = Math.min(pre[j],pre[j-1])+val;
                }
            }
        }

        return Arrays.stream(dp[(triangle.size()-1)%2]).min().getAsInt();
    }
}
