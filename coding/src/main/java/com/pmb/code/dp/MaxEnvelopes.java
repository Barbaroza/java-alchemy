package com.pmb.code.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 俄罗斯套娃信封问题
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * <p>
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * <p>
 * 说明:
 * 不允许旋转信封。
 * <p>
 * 示例:
 * <p>
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * @star
 * @author lvrui
 */
public class MaxEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        int res = 0;
        if (envelopes == null || envelopes.length < 1) {
            return res;
        }
        int dp[] = new int[envelopes.length];
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                int v = a1[0] - a2[0];
                return v == 0 ? a2[1] - a1[1] : v;
            }
        });
        for (int i = 0; i < envelopes.length; ++i) {
            dp[i] = envelopes[i][1];
        }


        res = dp[dp.length - 1];

        return length(dp);

    }

    private int length(int[] nums) {
        int[] dp = new int[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            result = Math.max(dp[i], result);
        }

        return result;
    }

    public static void main(String[] args) {
        MaxEnvelopes maxEnvelopes = new MaxEnvelopes();
        maxEnvelopes.maxEnvelopes(new int[][]{new int[]{5, 4}, new int[]{6, 4}
                , new int[]{6, 7}, new int[]{2, 3}});
    }
}
