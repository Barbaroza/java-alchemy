package com.pmb.code.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/0on3uN/submissions/
 * @author lvrui
 */
public class RestoreIpAddresses {
    private static final String QUTE =  ".";
    public List<String> restoreIpAddresses(String s) {

        List<String> ans = new ArrayList();

        if(s == null || s.length() <4){
            return ans;
        }

        LinkedList<String> path = new  LinkedList();
        final int l = s.length();
        dfs(0,path,s,l,ans,4);

        return ans;
    }


    private void dfs(int start,LinkedList<String> path,String s, final int l, List<String> ans,int cnt){

        if(start>l||cnt<0||(l-start+1)<cnt){
            return;
        }

        if(cnt == 0 && start == l){
            ans.add(String.join(QUTE,path));
            return;
        }

        for(int i =1;start+i<=l&&i<4;i++){
            String slice = s.substring(start,start+i);
            if(!validSlice(slice)){
                break;
            }

            path.addLast(slice);
            dfs(start+i,path,s,l,ans,cnt-1);
            path.removeLast();

            if(i==1 && slice .equals( "0")){
                break;
            }
        }

    }

    private boolean validSlice(String slice){
        if(slice == null){
            return false;
        }
        int l = slice.length();
        boolean valid = true;



        valid &= (256>Integer.valueOf(slice));
        return valid;
    }
}
