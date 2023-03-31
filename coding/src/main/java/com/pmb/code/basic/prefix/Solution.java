package com.pmb.code.basic.prefix;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/cuyjEf/
 * @author lvrui
 */
public class Solution {
    int total;
    Node[] arr;
    public Solution(int[] w) {
        arr = new Node[w.length];
        total = 0;
        for(int i = 0;i<w.length;i++){
            arr[i] =  new Node(i,w[i]);
            total +=w[i];
        }



    }

    public int pickIndex() {
        int ans = -1;
        int max = Integer.MIN_VALUE;

        for(int i =0;i<arr.length;i++){
            arr[i].cur +=arr[i].val;
            if(max<arr[i].cur){
                max = arr[i].cur;
                ans = arr[i].index;
            }
        }

        arr[ans].cur -= total;

        return ans;
    }


    public static class Node{
        int index;
        int val;
        int cur;
        public Node(int i,int v){
            cur = 0;
            index = i;
            val = v;
            cur = v;
        }
    }



}
