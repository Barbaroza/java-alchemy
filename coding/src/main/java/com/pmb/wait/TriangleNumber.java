package com.pmb.wait;

import java.util.Arrays;

/**
 * 611.
 * 有效三角形的个数
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 注意:
 * <p>
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 * 通过次数23,926提交次数46,893
 * @wait-v
 * @author lvrui
 */
public class TriangleNumber {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);

        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int s = nums[i] + nums[j];
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    int mid = l + r + 1 >>> 1;
                    if (nums[mid] < s) l = mid;
                    else r = mid - 1;
                }
                if (nums[r] < s) {
                    cnt = r - j;
                }


            }
        }
        return cnt;
    }
    public int triangleNumber3(int[] nums) {
        int cnt = 0;

        Arrays.sort(nums);


        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int third = Arrays.binarySearch(nums, nums[i] + nums[j]);
                if (third > j) {
                    cnt += (third - j);
                }

            }
        }

        return cnt;
    }
    public static void main(String[] args) {
        TriangleNumber triangleNumber = new TriangleNumber();
        int i = triangleNumber.triangleNumber(new int[]{24, 3, 82, 22, 35, 84, 19});
    }

}
