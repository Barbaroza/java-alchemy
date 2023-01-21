package com.pmb.code.datastructure.array;

import java.util.Random;

/**
 * 打乱一个没有重复元素的数组。
 * <p>
 * 示例:
 * <p>
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * NumDecodings solution = new NumDecodings(nums);
 * <p>
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 * <p>
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 * <p>
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 *
 * @author lvrui
 */
public class ChaoArrary {

    private int[] org;
    private int[] random;
    private Random seed;

    public ChaoArrary(int[] nums) {
        this.org = nums;
        this.random = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return this.org;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        if (this.seed == null) {
            this.seed = new Random();
        }
        for (int i = this.random.length - 1; i > 1; i--) {
            int tempValue = this.random[i];
            int randomIndex = this.seed.nextInt(i + 1);
            this.random[i] = this.random[randomIndex];
            this.random[randomIndex] = tempValue;
        }
        return this.random;
    }

}
