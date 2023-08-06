package com.pmb.wait.wait_2022_12_01;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-322/problems/divide-players-into-teams-of-equal-skill/
 *
 * @author lvrui
 */
public class DividePlayers {
    public long dividePlayers(int[] skill) {
        int dd = skill.length / 2;
        int tSum = Arrays.stream(skill).sum() / dd;

        int[] map = new int[1001];
        for (int s : skill) {
            map[s]++;
        }
        Long res = 0L;
        for (int i = 0; i < map.length; i++) {

            while (map[i] > 0) {

                int d = tSum - i;
                if (d > map.length - 1 || map[d] < 1) {
                    return -1L;
                }
                map[d]--;
                map[i]--;
                res += (d * i);
            }

        }

        return res;
    }

    public long dividePlayers2(int[] skill) {
        Arrays.sort(skill);
        int sum = skill[0] + skill[skill.length - 1];
        long out = 0;
        for (int i = 0; i < skill.length - 1 - i; i++) {
            if (skill[i] + skill[skill.length - 1 - i] != sum) {
                return -1;
            }
            out += ((long) skill[i]) * skill[skill.length - 1 - i];
        }
        return out;
    }

    public static void main(String[] args) {
        DividePlayers dividePlayers = new DividePlayers();
        dividePlayers.dividePlayers(new int[]{3, 4});
    }
}
