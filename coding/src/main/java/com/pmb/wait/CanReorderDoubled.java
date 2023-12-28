package com.pmb.wait;

import java.util.HashMap;
import java.util.Map;

/**
 * 954. 二倍数对数组
 * 给定一个长度为偶数的整数数组 A，只有对 A 进行重组后可以满足 “对于每个 0 <= i < len(A) / 2，都有 A[2 * i + 1] = 2 * A[2 * i]” 时，返回 true；否则，返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[3,1,3,6]
 * 输出：false
 * 示例 2：
 *
 * 输入：[2,1,2,6]
 * 输出：false
 * 示例 3：
 *
 * 输入：[4,-2,2,-4]
 * 输出：true
 * 解释：我们可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 * 示例 4：
 *
 * 输入：[1,2,4,16,8,4]
 * 输出：false
 *
 *
 * 提示：
 *
 * 0 <= A.length <= 30000
 * A.length 为偶数
 * -100000 <= A[i] <= 100000
 * @author lvrui
 *
 * @wait-v
 */
public class CanReorderDoubled {

    public static boolean canReorderDoubled(int[] a) {
        if (a == null || a.length % 2 == 1 || a.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : a) {
            Integer cnt = map.getOrDefault(num, 0);
            if (cnt == 0) {
                continue;
            }
            int targetCnt = 0;
            int target = Integer.MAX_VALUE;
            if (num % 2 == 0) {
                target = num / 2;
                targetCnt = map.getOrDefault(target, 0);
            }
            if (targetCnt == 0) {
                target = num * 2;
                targetCnt = map.getOrDefault(target, 0);
            }
            if (targetCnt > 0) {
                map.put(target, --targetCnt);
            } else {
                return false;
            }
        }

        return true;
    }}
