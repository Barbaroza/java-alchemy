package com.pmb.wait;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 823. 带因子的二叉树
 * 给出一个含有不重复整数元素的数组，每个整数均大于 1。
 * <p>
 * 我们用这些整数来构建二叉树，每个整数可以使用任意次数。
 * <p>
 * 其中：每个非叶结点的值应等于它的两个子结点的值的乘积。
 * <p>
 * 满足条件的二叉树一共有多少个？返回的结果应模除 10 ** 9 + 7。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: A = [2, 4]
 * 输出: 3
 * 解释: 我们可以得到这些二叉树: [2], [4], [4, 2, 2]
 * 示例 2:
 * <p>
 * 输入: A = [2, 4, 5, 10]
 * 输出: 7
 * 解释: 我们可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= A.length <= 1000.
 * 2 <= A[i] <= 10 ^ 9.
 *
 * @author lvrui
 */
public class NumFactoredBinaryTrees {


    public int numFactoredBinaryTrees(int[] A) {
        int MOD = 1_000_000_007;
        int N = A.length;
        Arrays.sort(A);
        long[] dp = new long[N];
        Arrays.fill(dp, 1);

        Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < N; ++i)
            index.put(A[i], i);

        for (int i = 0; i < N; ++i)
            for (int j = 0; j < i; ++j) {
                if (A[i] % A[j] == 0) { // A[j] is left child
                    int right = A[i] / A[j];
                    if (index.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % MOD;
                    }
                }
            }

        long ans = 0;
        for (long x : dp) ans += x;
        return (int) (ans % MOD);
    }

}
