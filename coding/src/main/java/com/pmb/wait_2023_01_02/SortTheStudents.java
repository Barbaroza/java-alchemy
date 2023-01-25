package com.pmb.wait_2023_01_02;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-329/problems/sort-the-students-by-their-kth-score/
 * @author lvrui
 */
public class SortTheStudents {
    public int[][] sortTheStudents(int[][] score, int k) {

        Arrays.sort(score,(a,b)->{
            return b[k] - a[k];
        });


        return score;
    }
}
