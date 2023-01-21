package com.pmb.wait;

import java.util.Arrays;

/**
 * 869. 重新排序得到 2 的幂
 * 给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * <p>
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：1
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：10
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：16
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：24
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：46
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10^9
 *
 * @author lvrui
 */
public class ReorderedPowerOf2 {
    boolean[] vis;

    public boolean reorderedPowerOf2(int n) {
        char[] nums = Integer.toString(n).toCharArray();
        Arrays.sort(nums);
        vis = new boolean[nums.length];
        return backtrack(nums, 0, 0);
    }

    public boolean backtrack(char[] nums, int idx, int num) {
        if (idx == nums.length) {
            System.out.println(num);

            return isPowerOfTwo(num);
        }
        for (int i = 0; i < nums.length; ++i) {
            // 不能有前导零
            if ((num == 0 && nums[i] == '0') || vis[i] || (i > 0 && !vis[i - 1] && nums[i] == nums[i - 1])) {
                continue;
            }
            vis[i] = true;
            if (backtrack(nums, idx + 1, num * 10 + nums[i] - '0')) {
                return true;
            }
            vis[i] = false;
        }
        return false;
    }

    public boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }


    public static void main(String[] args) {
        ReorderedPowerOf2 s = new ReorderedPowerOf2();

        s.reorderedPowerOf2(1);

        String testing = "ab";

        char[] chars = testing.toCharArray();

        boolean[] visited = new boolean[testing.length()];

        all(visited, 0, "", chars);

    }

    private static void all(boolean[] visited, int i, String s, char[] chars) {
        if (i == visited.length) {
            System.out.println(s);
        }

        for (int index = 0; index < visited.length; index++) {
            if (visited[index]) {
                continue;
            }
            visited[index] = true;

            all(visited, i + 1, s + chars[index], chars);

            visited[index] = false;
        }
    }


}
