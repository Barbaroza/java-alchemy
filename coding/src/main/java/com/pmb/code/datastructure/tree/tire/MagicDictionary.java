package com.pmb.code.datastructure.tree.tire;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/US1pGT/
 * @author lvrui
 */
public class MagicDictionary {
    Set<String> unique = new HashSet();
    /** Initialize your data structure here. */
    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        unique = Arrays.stream(dictionary).collect(Collectors.toSet());
    }

    public boolean search(String searchWord) {


        for(String word : unique){
            if(word.length()!=searchWord.length()){
                continue;
            }
            int diff = 0;
            for(int i =0 ;i<word.length()&& diff<2;i++){
                if(word.charAt(i)!=searchWord.charAt(i)){
                    diff++;
                }
            }
            if(diff == 1){
                return true;
            }

        }

        return false;
    }
}
