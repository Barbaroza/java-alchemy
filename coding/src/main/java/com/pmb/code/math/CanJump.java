package com.pmb.code.math;

import java.util.HashSet;
import java.util.Set;

/**
 * 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * @author lvrui
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        boolean res = findWay(nums, 0, set);
        return res;
    }

    private boolean findWay(int[] nums, int i, Set<Integer> set) {
        boolean res = false;
        if (set.contains(i)) {
            return res;
        }
        if (i >= nums.length - 1) {
            res = true;
        } else {
            int maxStep = nums[i];
            for (int index = maxStep; index > 0; index--) {
                if (findWay(nums, i + index, set)) {
                    res = true;
                    break;
                }
            }
            if (!res) {
                set.add(i);
            }
        }
        return res;
    }

    /**
     * G A
     *
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {

            temp = Math.max(temp, i + nums[i]);
            if (temp >= nums.length - 1)
                return true;
            if (temp <= i)
                return false;
        }
        return false;
    }

    /**
     * D P
     *
     * @param nums
     * @return
     */
    public boolean canJump3(int[] nums) {
        boolean[] can = new boolean[nums.length];
        can[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && (j + nums[j]) >= i) {
                    can[i] = true;
                }
            }
        }
        return can[nums.length - 1];
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        canJump.canJump(new int[]{3, 2, 1, 0, 4});
    }
}
