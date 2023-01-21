package com.pmb.wait_2022_12_01;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/contest/weekly-contest-322/problems/circular-sentence/
 */
public class IsCircularSentence {
    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");
        List<Character> temp = new ArrayList<>(s.length * 2);

        for (String t : s) {
            temp.add(t.charAt(0));
            temp.add(t.charAt(t.length() - 1));
        }

        for (int i = 0; i < temp.size() - 1; i++) {
            if (i == 0) {
                if (temp.get(0) != temp.get(temp.size() - 1)) {
                    return false;
                }
            } else {
                if (temp.get(i) != temp.get(i + 1)) {
                    return false;
                }
                i++;
            }
        }
        return true;


    }

    public boolean isCircularSentence2(String sentence) {
        String[] tokens = sentence.split(" ");
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i - 1].charAt(tokens[i - 1].length() - 1) != tokens[i].charAt(0)) {
                return false;
            }
        }
        return tokens[tokens.length - 1].charAt(tokens[tokens.length - 1].length() - 1) == tokens[0].charAt(0);
    }

    public static void main(String[] args) {
        IsCircularSentence sentence = new IsCircularSentence();

        boolean muFoevIXCZzrpXeRmTssj_lYSW_u_jM = sentence.isCircularSentence("MuFoevIXCZzrpXeRmTssj lYSW U jM");
    }
}
