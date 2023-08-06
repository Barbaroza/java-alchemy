package com.pmb.wait.wait_2022_05;

/**
 * @author lvrui
 * @Wait https://leetcode.cn/problems/can-i-win/
 * https://leetcode.cn/problems/can-i-win/solution/by-ac_oier-0ed9/
 * @status {to review}
 * 464. 我能赢吗
 * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和 达到或超过  100 的玩家，即为胜者。
 * <p>
 * 如果我们将游戏规则改为 “玩家 不能 重复使用整数” 呢？
 * <p>
 * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
 * <p>
 * 给定两个整数 maxChoosableInteger （整数池中可选择的最大数）和 desiredTotal（累计和），若先出手的玩家是否能稳赢则返回 true ，否则返回 false 。假设两位玩家游戏时都表现 最佳 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：maxChoosableInteger = 10, desiredTotal = 11
 * 输出：false
 * 解释：
 * 无论第一个玩家选择哪个整数，他都会失败。
 * 第一个玩家可以选择从 1 到 10 的整数。
 * 如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。
 * 第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.
 * 同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。
 * 示例 2:
 * <p>
 * 输入：maxChoosableInteger = 10, desiredTotal = 0
 * 输出：true
 * 示例 3:
 * <p>
 * 输入：maxChoosableInteger = 10, desiredTotal = 1
 * 输出：true
 */
public class CanIWin {
    public boolean canIWin1(int maxChoosableInteger, int desiredTotal) {
        int[] flag = new int[maxChoosableInteger + 1];

        return recursive(flag, 1, desiredTotal, 0);
    }

    private boolean recursive(int[] flag, int i, int desiredTotal, int cur) {
        int pick = -1;
        for (int index = 1; index < flag.length; index++) {
            if (flag[index] == 0) {
                pick = index;
                flag[pick] = 1;
                cur += pick;
                if (cur >= desiredTotal) {
                    if (i % 2 == 0) {
                        return false;
                    }
                } else {
                    if (!this.recursive(flag, i + 1, desiredTotal, cur)) {
                        return false;
                    }
                }

                flag[pick] = 0;
                cur -= pick;

            }
        }


        return pick != -1;

    }

    public boolean canIWin2(int maxChoosableInteger, int desiredTotal) {
        return false;
    }

    int n, t;
    int[][] f = new int[1 << 20][2];

    // 1 true / -1 false
    int dfs(int state, int tot, int k) {
        if (state == ((1 << n) - 1) && tot < t) {
            return -1;
        }
        if (f[state][k % 2] != 0) {
            return f[state][k % 2];
        }
        int hope = k % 2 == 0 ? 1 : -1;
        for (int i = 0; i < n; i++) {
            if (((state >> i) & 1) == 1) {
                continue;
            }
            if (tot + i + 1 >= t) {
                return f[state][k % 2] = hope;
            }
            if (dfs(state | (1 << i), tot + i + 1, k + 1) == hope) {
                return f[state][k % 2] = hope;
            }
        }
        return f[state][k % 2] = -hope;
    }

    public boolean canIWin(int _n, int _t) {
        n = _n;
        t = _t;
        if (t == 0) return true;
        return dfs(0, 0, 0) == 1;
    }


    public static void main(String[] args) {
        CanIWin canIWin = new CanIWin();
        boolean b = canIWin.canIWin1(4, 6);

        boolean b1 = canIWin.canIWin2(4, 6);


        canIWin.canIWin(4, 6);
        canIWin.canIWin1(10, 11);
    }

}
