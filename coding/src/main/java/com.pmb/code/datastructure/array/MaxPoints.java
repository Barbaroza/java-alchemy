package com.pmb.code.datastructure.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 直线上最多的点数
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * 示例 2:
 * <p>
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 *
 * @author lvrui
 */
public class MaxPoints {
    public int maxPoints(int[][] points) {
        int res = 0;
        if (points == null || points.length == 0) {
            return res;
        }
        if (points.length == 1) {
            return 1;
        }
        for (int i = 0; i < points.length; i++) {
            if (points.length - i <= res) {
                break;
            }
            Map<Double, Integer> map = new HashMap<>();
            int countZero = 1;
            int countXZero = 1;
            int defaultValue = 1;
            for (int j = i + 1; j < points.length; j++) {
                int div = (points[j][1] - points[i][1]);
                int deDiv = (points[j][0] - points[i][0]);
                if (div == 0 && deDiv == 0) {
                    int tempMax = 0;
                    for (Double key : map.keySet()) {
                        Integer count = map.get(key);
                        map.put(key, count + 1);
                        tempMax = Math.max(tempMax, count + 1);
                    }
                    defaultValue++;
                    countZero++;

                    countXZero++;
                    res = Math.max(res, Math.max(countXZero, Math.max(Math.max(tempMax, countZero), defaultValue)));
                } else if (div == 0) {
                    countZero++;
                    res = Math.max(res, countZero);
                } else if (deDiv == 0) {
                    countXZero++;
                    res = Math.max(res, countXZero);
                } else {
                    double x = (double) deDiv / (double) div;
                    Integer integer = map.putIfAbsent(x, defaultValue + 1);
                    if (integer != null) {
                        integer++;
                        map.put(x, integer);
                    } else {
                        integer = defaultValue + 1;
                    }
                    res = Math.max(res, integer);
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        MaxPoints maxPoints = new MaxPoints();
        maxPoints.maxPoints(new int[][]{new int[]{0, -12}
                , new int[]{5, 2}
                , new int[]{2, 5}
                , new int[]{0, -5}
                , new int[]{1, 5}
                , new int[]{2, -2}
                , new int[]{5, -4}
                , new int[]{3, 4}
                , new int[]{-2, 4}
                , new int[]{-1, 4}
                , new int[]{0, -5}
                , new int[]{0, -5}
                , new int[]{-2, -1}
                , new int[]{0, -11}, new int[]{0, 9}});
    }
}
