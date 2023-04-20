package com.pmb.code.math;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/best-line-lcci/solution/shu-xue-ti-zhi-xian-de-yi-ban-shi-fang-cheng-by-tu/
 *
 * @author lvrui
 */
public class BestLine {
    public int[] bestLine(int[][] points) {
        int max = 0;
        int maxHash = 0;
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, int[]> record = new HashMap<>();
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                long A = points[j][1] - points[i][1];
                long B = points[i][0] - points[j][0];
                long C = ((long) points[j][0]) * points[i][1] - ((long) points[i][0]) * points[j][1];
                long gcd = gcd(gcd(A, B), C);
                A /= gcd;
                B /= gcd;
                C /= gcd;
                int hash = hash((int) A, (int) B, (int) C);
                int count = map.getOrDefault(hash, 0) + 1;
                map.put(hash, count);
                if (count == 1) record.put(hash, new int[]{i, j});
                if (count > max) {
                    max = count;
                    maxHash = hash;
                    res = record.get(hash);
                } else if (count == max) {
                    int[] t1 = record.get(maxHash);
                    int[] t2 = record.get(hash);
                    if (t1[0] > t2[0] || t1[0] == t2[0] && t1[1] > t2[1]) {
                        maxHash = hash;
                        res = t2;
                    }
                }
            }
        }
        return res;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    //随便写的hash方法。反正数据量也不大。冲突可能性小
    private int hash(int a, int b, int c) {
        a = (a ^ (a >>> 16) & 0x0000ffff) << 20;
        b = (b ^ (b >>> 16) & 0x0000ffff) << 10;
        c = c ^ (c >>> 16) & 0x00000ffff;
        return a | b | c;
    }

}
