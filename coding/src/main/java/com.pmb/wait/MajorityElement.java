package com.pmb.wait;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * @author Administrator
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int result = find(nums, 0, nums.length - 1);
        return result;
    }


    public int find(int[] nums, int begin, int end) {
        if (begin == end)
            return nums[begin];
        else {
            int mid = (begin + end) / 2;
            int left = find(nums, begin, mid);
            int right = find(nums, mid + 1, end);

            if (left == right)//左右两部分的众数相同 则这个数是这部分的众数
                return left;
            else {//左右两部分的众数不相同 则这两个数都有可能是这部分的众数
                //那么遍历这个数组 看一下哪个数字的出现频率高
                int countLeft = 0;
                int countRight = 0;

                for (int i = begin; i <= end; i++)
                    if (nums[i] == left)
                        countLeft++;
                    else if (nums[i] == right)
                        countRight++;

                if (countLeft >= countRight)
                    return left;
                else
                    return right;
            }
        }
    }


    public static void main(String[] args) {
    }
}
