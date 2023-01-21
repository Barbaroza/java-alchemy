package com.pmb.wait_2022_11_03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * https://leetcode.cn/contest/weekly-contest-320/problems/number-of-beautiful-partitions/
 *
 * @author lvrui
 */
public class BeautifulPartitions {

    private static final Set<Integer> YES = new HashSet<>();
    private static final Integer MOD = 1000000007;

    static {
        YES.add(2);
        YES.add(3);
        YES.add(5);
        YES.add(7);
    }

    public int beautifulPartitions(String s, int k, int minLength) {
        char[] chars = s.toCharArray();
        if (minLength * 3 > chars.length) {
            return 0;
        }
        int[] ints = IntStream.range(0, chars.length).map(c -> {
            return (int) (chars[c] - '0');
        }).toArray();
        if (!YES.contains(ints[0])) {

            return 0;
        }
        if (YES.contains(ints[chars.length - 1])) {
            return 0;
        }
        k = k - 1;
        if (k == 0) {
            return 1;
        }
        int res = split(ints, 0, k, k, minLength);

        return res;

    }

    private int split(int[] ints, int start, int cnt, int k, int minLength) {
        int sum = 0;


        for (int i = start + minLength - 1; i < ints.length - (cnt) * minLength; i++) {
            if (YES.contains(ints[i]) || !YES.contains(ints[i + 1])) {
                continue;
            }
            System.out.println(i);
            if (cnt == 1) {
                sum += 1 % MOD;
            } else {
                sum += split(ints, i + 1, cnt - 1, k, minLength) % MOD;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        BeautifulPartitions b = new BeautifulPartitions();
        b.beautifulPartitions2("242538614532395749146912679859", 1, 6);
    }

    public int beautifulPartitions2(String s, int k, int minLength) {
        HashSet<Character> zhishu = new HashSet<>();
        HashSet<Character> fuhsu = new HashSet<>();
        zhishu.add('2');
        zhishu.add('3');
        zhishu.add('5');
        zhishu.add('7');
        fuhsu.add('1');
        fuhsu.add('4');
        fuhsu.add('6');
        fuhsu.add('8');
        fuhsu.add('9');
        if (!zhishu.contains(s.charAt(0))) return 0;
        int length = s.length();
        List<Integer> list = new ArrayList<>();
        long[][] dp = new long[length + 1][k + 1];
        dp[0][0] = 1;
        list.add(0);
        for (int i = 1; i < length; i++) {
            if (zhishu.contains(s.charAt(i)) && fuhsu.contains(s.charAt(i - 1))) {
                list.add(i);
            } else if (fuhsu.contains(s.charAt(i))) {
                for (Integer integer : list) {
                    if (i - integer + 1 < minLength) break;
                    for (int j = 0; j < k; j++) {
                        dp[i + 1][j + 1] += dp[integer][j];
                        dp[i + 1][j + 1] %= 1000000007;
                    }
                }
            }
        }
        return (int) dp[length][k];
    }

}
