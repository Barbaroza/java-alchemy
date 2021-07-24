package com.pmb.wait;

import java.util.Arrays;

/**
 * 1838. 最高频元素的频数
 * 元素的 频数 是该元素在一个数组中出现的次数。
 *
 * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 *
 * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,4], k = 5
 * 输出：3
 * 解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
 * 4 是数组中最高频元素，频数是 3 。
 * 示例 2：
 *
 * 输入：nums = [1,4,8,13], k = 5
 * 输出：2
 * 解释：存在多种最优解决方案：
 * - 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
 * - 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
 * - 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
 * 示例 3：
 *
 * 输入：nums = [3,9,6], k = 2
 * 输出：1
 * @author lvrui
 */
public class MaxFrequency {
    public int maxFrequency(int[] nums, int k) {

    }

    public int maxFrequency2(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0,r = 1;
        int max = 1; //最大频数
        long total = 0; //操作数
        while(r < n){
            /* r从1开始，比如1，4，8，13，此时是4，需要把1变成当前数字nums[r]，需要的次数则是1*3次
            此时total所代表的数都已经变成了4，此时遍历下一位8，因为前面的数字都是相等的，所以通过计算
            (r-l)*(nums[r]-nums[r-1])即可计算新的total值
            但是每次计算total后都要检查是否超过k，如果超过了k则需要不断从total中减去nums[l]的值
            为什么是减去nums[l]的值呢？
            数组是有序的，从后一个数变成更大的数x代价一定要比前一个数变成x的代价小，所以这里需要不断减去
            nums[l]的值更新total以使得total重新 <= k,因为max会记录每次最大的频数，也不用担心会漏掉
            */
            total += (r-l)*(nums[r]-nums[r-1]);
            while(total > k && l < r){
                total -= nums[r]-nums[l++];
            }
            max = Math.max(max,r-l+1);
            r++;
        }
        return max;
    }

}
