package com.pmb.code.dp;

/**
 * https://leetcode.cn/problems/cyJERH/submissions/
 * @author lvrui
 */
public class MinFlipsMonoIncr {
    private static final char ZERO =  '0';
    private static final char ONE = '1';
    public int minFlipsMonoIncr(String s) {
        int [] preMinCost =  new int [2];

        for(int i = 0; i<s.length();i++){
            boolean  isZero = s.charAt(i) == ZERO;

            if(isZero){
                preMinCost[1] = Math.min(preMinCost[0],preMinCost[1])+1;

            }else{
                preMinCost[1] = Math.min(preMinCost[0],preMinCost[1]);
                preMinCost[0] = preMinCost[0]+1;
            }
        }

        return Math.min(preMinCost[0],preMinCost[1]);

    }
}
