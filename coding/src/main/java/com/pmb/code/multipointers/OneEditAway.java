package com.pmb.code.multipointers;

/**
 * https://leetcode.cn/problems/one-away-lcci/submissions/
 *
 * @author lvrui
 */
public class OneEditAway {
    public boolean oneEditAway(String a, String b) {
        int la = a.length();
        int lb = b.length();
        if (Math.abs(la - lb) > 1) {
            return false;
        }
        if (lb > la) {
            return oneEditAway(b, a);
        }

        int i = 0;
        int j = 0;
        int cnt = 0;
        while (i < la && j < lb && cnt <= 1) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                if (la > lb) {
                    i++;
                } else {
                    i++;
                    j++;
                }

                cnt++;
            }
        }

        return cnt <= 1;

    }

}
