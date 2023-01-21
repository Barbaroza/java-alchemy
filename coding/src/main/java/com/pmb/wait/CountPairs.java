package com.pmb.wait;

import java.util.HashMap;
import java.util.Map;

/**
 * 1711. 大餐计数
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 * <p>
 * 你可以搭配 任意 两道餐品做一顿大餐。
 * <p>
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
 * <p>
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 * 示例 2：
 * <p>
 * 输入：deliciousness = [1,1,1,3,3,3,7]
 * 输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 * <p>
 * <p>
 * 提示：
 *
 * @author lvrui
 */
public class CountPairs {
    final int MOD = 1000000007;

    public int countPairs(int[] deliciousness) {
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int cd : deliciousness) {
            max = Math.max(cd, max);
            Integer integer = cnt.get(cd);
            if (integer == null) {
                cnt.put(cd, 1);
            } else {
                cnt.put(cd, ++integer);
            }
        }
        int res = 0;
        for (int cd : deliciousness) {
            int temp = 1;
            while (temp <= 2 * max) {
                Integer integer = cnt.get(temp - cd);
                if (integer != null) {
                    if (cd * 2 == temp) {

                        res += integer - 1;
                    } else {
                        res += integer;

                    }

                    res %= MOD;
                }
                temp = temp << 1;
            }
        }

        return res >> 1;
    }

    public int countPairs2(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal = 0;
        for (int val : deliciousness) {
            maxVal = Math.max(maxVal, val);
        }
        int maxSum = maxVal * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = deliciousness.length;
        for (int i = 0; i < n; i++) {
            int val = deliciousness[i];
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }


    public static void main(String[] args) {
        CountPairs countPairs = new CountPairs();
        int i = countPairs.countPairs(new int[]{149, 107, 1, 63, 0, 1, 6867, 1325, 5611, 2581, 39, 89, 46, 18, 12, 20, 22, 234});
    }
}
