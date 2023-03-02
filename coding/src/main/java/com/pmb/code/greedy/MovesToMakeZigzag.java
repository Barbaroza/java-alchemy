package com.pmb.code.greedy;

/**
 * https://leetcode.cn/problems/decrease-elements-to-make-array-zigzag/submissions/
 * @author lvrui
 */
public class MovesToMakeZigzag {
    public int movesToMakeZigzag(int[] nums) {
        int c1 =0;
        int c2 =0;
        for(int i = 0;i<nums.length;i++){
            if(((i+1)&1)==1){
                c1+= cost(i,nums);
            }else{
                c2+= cost(i,nums);
            }
        }

        return Math.min(c1,c2);
    }


    private int cost(int i,int[] nums){
        int left = i > 0 ? nums[i - 1] : Integer.MAX_VALUE;
        int right = i < nums.length - 1 ? nums[i + 1] : Integer.MAX_VALUE;
        return  Math.max(nums[i] - Math.min(left, right) + 1, 0);

    }
}
