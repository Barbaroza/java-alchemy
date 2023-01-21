package com.pmb.wait_2022_06;

import java.util.Arrays;
import java.util.List;

/**
 * @author lvrui
 *  https://leetcode.cn/problems/koko-eating-bananas/
 * 875. 爱吃香蕉的珂珂
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 * 示例 3：
 * <p>
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= piles.length <= 104
 * piles.length <= h <= 109
 * 1 <= piles[i] <= 109
 */
public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int divisor = h / piles.length;
        Arrays.sort(piles);
        int res = 0;

        int min = piles[0] / divisor;
        int max = (piles[piles.length - 1] + 1) / divisor;
//        for (int i = min; i <= max; i++) {
//            int k = i;
//            int cost = 0;
//            for (int j = piles.length - 1; j >= 0; j--) {
//
//                int remainder = piles[j] % k;
//                cost += remainder == 0 ? piles[j] / k : piles[j] / k + 1;
//                if (cost > h) {
//                    break;
//                }
//            }
//            if (cost == h) {
//                res = i;
//                break;
//            }
//        }


        res = this.binarySearch(min, max, piles, h);
        return res;
    }



    public int binarySearch(int min, int max, int[] piles, int h) {
        int left = min==0?1:min, right = max + 1;
        while (left < right) {
            int mid = (right + left) / 2;

            int k = mid;
            int cost = 0;
            for (int j = piles.length-1; j >=0; j--) {

                cost +=  (piles [j] + k - 1) / k;
                if (cost > h) {
                    break;
                }

            }
            if (cost > h) {
                left = mid + 1;
            }
            if (cost == h) {
                right = mid;
            }
            if (cost < h) {
                right = mid;
            }
        }
        return right;
    }
    public int minEatingSpeed2(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        int k = high;
        while (low < high) {
            int speed = (high - low) / 2 + low;
            long time = getTime(piles, speed);
            if (time <= h) {
                k = speed;
                high = speed;
            } else {
                low = speed + 1;
            }
        }
        return k;
    }

    public long getTime(int[] piles, int speed) {
        long time = 0;
        for (int pile : piles) {
            int curTime = (pile + speed - 1) / speed;
            time += curTime;
        }
        return time;
    }


    public static void main(String[] args) {
        MinEatingSpeed minEatingSpeed = new MinEatingSpeed();

        int i = minEatingSpeed.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5);
        int i2 = minEatingSpeed.minEatingSpeed(new int[]{312884470}, 968709470);
    }

    @FunctionalInterface
    interface CollectionSupports {
        <T> boolean isSame(T e1, T e2);

    }

    public static <T> void merge(List<T> list1, List<T> list2, CollectionSupports supports) {
        if (list1 == null || list2 == null || list2.size() == 0) {
            return;
        }
        list2.stream().filter(e2 -> list1.stream().noneMatch(e1 -> supports.isSame(e1, e2))).forEach(list1::add);
    }
}
