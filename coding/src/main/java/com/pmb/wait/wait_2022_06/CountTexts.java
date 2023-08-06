package com.pmb.wait.wait_2022_06;

/**
 * @Wait
 * https://leetcode.cn/problems/count-number-of-texts/
 * 2266. 统计打字方案数
 * Alice 在给 Bob 用手机打字。数字到字母的 对应 如下图所示。
 * <p>
 * <p>
 * <p>
 * 为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。
 * <p>
 * 比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母  'k' 。
 * 注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。
 * 但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。
 * <p>
 * 比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。
 * 给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。
 * <p>
 * 由于答案可能很大，将它对 109 + 7 取余 后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：pressedKeys = "22233"
 * 输出：8
 * 解释：
 * Alice 可能发出的文字信息包括：
 * "aaadd", "abdd", "badd", "cdd", "aaae", "abe", "bae" 和 "ce" 。
 * 由于总共有 8 种可能的信息，所以我们返回 8 。
 *
 * @author lvrui
 */
public class CountTexts {
    int d = 1000000009;
    final int MOD = (int) (1e9 + 7);

    public int countTexts(String pressedKeys) {
        int mod = (int) 1e9 + 7;
        // 分两种情况，当前i与i-1的字符相同，不相同
        // 不相同：dp[i] += dp[i - 1]
        // 相同：与i-1相同 dp[i] += dp[i-1] + dp[i-2]
        // 与i-2也相同：dp[i] += dp[i-3]
        int n = pressedKeys.length();
        char[] chs = pressedKeys.toCharArray();
        // dp[i]表示以pressKey[i]结尾的方案个数
        long[] dp = new long[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];
            if (chs[i] == chs[i - 1]) {
                dp[i] += i >= 2 ? dp[i - 2] : 1;
                if (i >= 2 && chs[i] == chs[i - 2]) {
                    dp[i] += i >= 3 ? dp[i - 3] : 1;
                    if ((chs[i] == '7' || chs[i] == '9') && i >= 3 && chs[i] == chs[i - 3]) {
                        dp[i] += i >= 4 ? dp[i - 4] : 1;
                    }
                }
            }
            dp[i] %= mod;
        }
        return (int) dp[n - 1];
    }

    public int countTexts0(String pressedKeys) {
        long ans = 1;
        int n = pressedKeys.length();
        for (int i = 0; i < n; ) {
            char ch = pressedKeys.charAt(i);

            if (ch == '7' || ch == '9') {
                //dp4
                int cnt = 1;
                while (++i < n && pressedKeys.charAt(i) == ch) cnt++;
                ans = ans * count4(cnt) % MOD;
            } else {
                //dp3
                int cnt = 1;
                while (++i < n && pressedKeys.charAt(i) == ch) cnt++;
                ans = ans * count3(cnt) % MOD;
            }
        }
        return (int) ans;
    }

    public int count3(int cnt) {
        // System.out.println("3:"+cnt);
        long[] dp = new long[cnt + 1];
        //初始化
        if (cnt == 1) {
            return 1;
        } else if (cnt == 2) {
            return 2;
        } else if (cnt == 3) {
            return 4;
        }
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= cnt; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
        }
        return (int) dp[cnt];
    }


    public int count4(int cnt) {
        // System.out.println("4:"+cnt);
        long[] dp = new long[cnt + 1];
        //初始化
        if (cnt == 1) {
            return 1;
        } else if (cnt == 2) {
            return 2;
        } else if (cnt == 3) {
            return 4;
        } else if (cnt == 4) {
            return 8;
        }
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 8;

        for (int i = 5; i <= cnt; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4]) % MOD;
        }
        return (int) dp[cnt];
    }


    public static void main(String[] args) {
        CountTexts countTexts = new CountTexts();
        int i = countTexts.countTexts0("22233");
    }
}
