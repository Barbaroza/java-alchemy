package com.pmb.code.datastructure.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/qn8gGX/submissions/
 * @author lvrui
 */
public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(k,(a,b)->{
            return -nums1[b[0]]-nums2[b[1]] + nums1[a[0]]+nums2[a[1]];
        });
        int l = Math.min(nums1.length,k);
        for(int i = 0;i<l;i++){
            minHeap.offer(new int[]{i,0});
        }
        List<List<Integer>> ans = new ArrayList();
        while(k-->0&&!minHeap.isEmpty()){
            int[] max = minHeap.poll();
            List<Integer> t = new ArrayList(2);
            t.add(nums1[max[0]]);
            t.add(nums2[max[1]]);
            ans.add(t);

            if(max[1]+1<nums2.length){
                minHeap.offer(new int[]{max[0],max[1]+1});
            }
        }
        return ans;
    }
}
