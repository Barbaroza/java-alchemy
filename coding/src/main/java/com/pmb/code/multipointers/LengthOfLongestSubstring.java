package com.pmb.code.multipointers;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/wtcaE1/submissions/
 * @author lvrui
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> unique = new HashSet<>();
        char[] chars = s.toCharArray();
        int ans = 0;
        int r = 0;
        int l = 0;
        int n = chars.length;
        while(r<n){

            while(unique.contains(chars[r])){
                unique.remove(chars[l++]);
            }
            unique.add(chars[r++]);
            ans = Math.max(ans,r-l);
        }


        return ans;
    }
}
