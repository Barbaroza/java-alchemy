package com.pmb.wait.wait_2022_01_04;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/count-vowels-permutation/
 * 1220. 统计元音字母序列的数目
 * 给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：
 * <p>
 * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
 * 每个元音 'a' 后面都只能跟着 'e'
 * 每个元音 'e' 后面只能跟着 'a' 或者是 'i'
 * 每个元音 'i' 后面 不能 再跟着另一个 'i'
 * 每个元音 'o' 后面只能跟着 'i' 或者是 'u'
 * 每个元音 'u' 后面只能跟着 'a'
 * 由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：5
 * 解释：所有可能的字符串分别是："a", "e", "i" , "o" 和 "u"。
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：10
 * 解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" 和 "ua"。
 * 示例 3：
 * <p>
 * 输入：n = 5
 * 输出：68
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2 * 10^4
 * <p>
 * 除了dfs，可能我们还能想到用动态规划来求解这个题目
 * <p>
 * dp[i] [j] 数组的含义是长度为i的字符串，以j字符为结尾的字符串的个数，这里的j根据题目可以取 a、e、i、o和u。根据规律可以写出状态转移方程为
 * <p>
 * dp[i] [0] = dp[i-1] [1] + dp[i-1] [2] + dp[i-1] [4]
 * dp[i] [1] = dp[i-1] [0] + dp[i-1] [2]
 * dp[i] [2] = dp[i-1] [1] + dp[i-1] [3]
 * dp[i] [3] = dp[i-1] [2]
 * dp[i] [4] = dp[i-1] [2] + dp[i-1] [3]
 * 本题目要求得就是dp[n] [0] + dp[n] [1] + dp[n] [2] +dp[n] [3] + dp[n] [4]
 * <p>
 * 这里可以对二位数组进行压缩，每一个位置的状态只与前一个位置的状态有关，设置一个一维长度为5的数组即可。
 *
 * @author lvrui
 */
public class CountVowelPermutation {
    char[] vRoot = new char[]{'a', 'e', 'i', 'o', 'u'};
    char[][] dj = new char[][]{{'e'}, {'a', 'i'}, {'a', 'e', 'o', 'u'}, {'i', 'u'}, {'a'}};
    Map<Character, Integer> indexMap = new HashMap() {{
        put('a', 0);
        put('e', 1);
        put('i', 2);
        put('o', 3);
        put('u', 4);
    }};

    Map<String, Integer> cntCache = new HashMap<>();

    private Integer d = (int) Math.pow(10, 9) + 7;

    public int countVowelPermutation(int n) {
        if (n < 1) {
            return 0;
        }


        return recursive(this.vRoot, n, n);
    }

    private int recursive(char[] child, int k, int n) {
        if (k == 1) {
            return child.length;
        }
        int cnt = 0;
        for (char c : child) {

            int cur = 0;
            String key = "" + c + (n - k);
            Integer cache = cntCache.get(key);
            if (cache == null) {
                cur = recursive(dj[indexMap.get(c)], k - 1, n) % d;
                cntCache.put(key, cur);
            }else {
                cur = cache;
            }

            cnt += cur;
        }
        return cnt;
    }
    public int countVowelPermutation2(int n) {
        long mod = 1000000007;
        long[] dp = new long[5];
        long[] ndp = new long[5];
        for (int i = 0; i < 5; ++i) {
            dp[i] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            /* a前面可以为e,u,i */
            ndp[0] = (dp[1] + dp[2] + dp[4]) % mod;
            /* e前面可以为a,i */
            ndp[1] = (dp[0] + dp[2]) % mod;
            /* i前面可以为e,o */
            ndp[2] = (dp[1] + dp[3]) % mod;
            /* o前面可以为i */
            ndp[3] = dp[2];
            /* u前面可以为i,o */
            ndp[4] = (dp[2] + dp[3]) % mod;
            System.arraycopy(ndp, 0, dp, 0, 5);
        }
        long ans = 0;
        for (int i = 0; i < 5; ++i) {
            ans = (ans + dp[i]) % mod;
        }
        return (int)ans;
    }


    public static void main(String[] args) {
        CountVowelPermutation countVowelPermutation = new CountVowelPermutation();
        int i = countVowelPermutation.countVowelPermutation(3);
    }
}
