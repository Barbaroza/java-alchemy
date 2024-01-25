package com.pmb.wait;

/**
 * @wait-v
 * 457. 环形数组循环
 * 给定一个含有正整数和负整数的环形数组 nums。 如果某个索引中的数 k 为正数，则向前移动 k 个索引。相反，如果是负数 (-k)，
 * 则向后移动 k 个索引。因为数组是环形的，所以可以假设最后一个元素的下一个元素是第一个元素，而第一个元素的前一个元素是最后一个元素。
 * <p>
 * 确定 nums 中是否存在循环（或周期）。循环必须在相同的索引处开始和结束并且循环长度 > 1。此外，一个循环中的所有运动都必须沿着同一方向进行。
 * 换句话说，一个循环中不能同时包括向前的运动和向后的运动。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,-1,1,2,2]
 * 输出：true
 * 解释：存在循环，按索引 0 -> 2 -> 3 -> 0 。循环长度为 3 。
 * 示例 2：
 * <p>
 * 输入：[-1,2]
 * 输出：false
 * 解释：按索引 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。
 * 示例 3:
 * <p>
 * 输入：[-2,1,-1,-2,-2]
 * 输出：false
 * 解释：按索引 1 -> 2 -> 1 -> ... 的运动无法构成循环，因为按索引 1 -> 2 的运动是向前的运动，而按索引 2 -> 1 的运动是向后的运动。
 * 一个循环中的所有运动都必须沿着同一方向进行。
 * <p>
 * <p>
 * 提示：
 * <p>
 * -1000 ≤ nums[i] ≤ 1000
 * nums[i] ≠ 0
 * 0 ≤ nums.length ≤ 5000
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能写出时间时间复杂度为 O(n) 和额外空间复杂度为 O(1) 的算法吗？
 *
 * @author lvrui
 */
public class CircularArrayLoop {

    public boolean circularArrayLoop(int[] nums) {
        if (nums.length == 0 || nums.length == 1 || nums == null) return false;//处理特殊情况
        for (int i = 0; i < nums.length; i++) {
            //慢指针j从i的位置开始移动(类似 slow = node)，快指针k从i移动一次以后的位置开始移动（类似 fast =node.next)
            int j = i;
            int k = next(nums, i);
            //保证快慢指针始终向着nums[i]表示的同一个方向移动,>0始终右，反之始终左
            while (nums[i] * nums[j] > 0 && nums[i] * nums[k] > 0 && nums[i] * nums[next(nums, k)] > 0) {
                //System.out.println("i"+i);
                if (j == k) {//快慢指针相遇(在循环中相遇，类似于在环形链表中相遇)
                    if (j == next(nums, j)) {
                        break;
                    }//循环长度未1不能true
                    return true;
                }


                j = next(nums, j);//移动慢指针 类似于slow=slow.next;
                //System.out.println("j"+j);
                k = next(nums, next(nums, k));//移动快指针，类似于fast= fast.next.next;
                //System.out.println("k"+k);
            }
        }
        return false;
    }

    //计算下一个位置时，避免越界
    private int next(int[] nums, int i) {
        int next = i + nums[i];
        if (next >= 0) return next % nums.length; //合并0~nums.length的部分
        else {
            return nums.length + next % nums.length;
        }
    }


}
