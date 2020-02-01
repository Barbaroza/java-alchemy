package com.pmb.code.datastructure.stack;

/**
 * 目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * 一共有5种方法让最终目标和为3。
 * 注意:
 * <p>
 * 数组非空，且长度不会超过20。
 * 初始的数组的和不会超过1000。
 * 保证返回的最终结果能被32位整数存下。
 *
 * @author lvrui
 */
public class FindTargetSumWays {

    public int findTargetSumWays(int[] nums, int S) {
        int[] count = new int[1];
        dfs(0, nums, S, count);
        return count[0];
    }

    private void dfs(int i, int[] nums, int s, int[] count) {
        if (i > nums.length - 1) {
            return;
        } else if (i == nums.length - 1) {
            if (s - nums[i] == 0) {
                count[0] += 1;
            }
            if (s + nums[i] == 0) {
                count[0] += 1;
            }
        } else {
            dfs(i + 1, nums, s - nums[i], count);
            dfs(i + 1, nums, s + nums[i], count);
        }

    }
}
