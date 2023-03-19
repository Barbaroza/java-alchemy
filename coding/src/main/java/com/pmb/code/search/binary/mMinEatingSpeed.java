package com.pmb.code.search.binary;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/nZZqjQ/submissions/
 * @author lvrui
 */
public class mMinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int r = Arrays.stream(piles).max().getAsInt();
        int l =1;
        while(l<r){
            int mid  = (r+l)/2;
            if(getTime(mid,piles)>h){
                l = mid +1;
            }else{
                r = mid;
            }
        }
        return r;
    }

    private int getTime(int mid ,int [] piles){
        return Arrays.stream(piles).map(e->(e+mid-1)/mid).sum();
    }
}
