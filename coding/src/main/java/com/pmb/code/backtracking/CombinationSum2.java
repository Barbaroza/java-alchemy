package com.pmb.code.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/4sjJUc/submissions/
 * @author lvrui
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans =new ArrayList();
        LinkedList<Integer> path = new LinkedList();
        dfs(0,ans,path,candidates,target);
        return ans;

    }

    private void dfs(int s, List<List<Integer>>ans, LinkedList<Integer> path, int[] candidates, int target){
        if(target == 0){
            ans.add(new ArrayList(path));
            return;
        }

        if(target<0|| s>candidates.length-1){
            return;
        }

        for(int i = s;i<candidates.length;i++){
            if(target<candidates[i]){
                break;
            }
            if(i>s && candidates[i] == candidates[i-1]){
                continue;

            }
            path.addLast(candidates[i]);

            dfs(i+1,ans,path,candidates,target-candidates[i]);

            path.removeLast();
        }
    }
}
