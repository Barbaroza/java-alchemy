package com.pmb.wait.wait_2022_11_05;

/**
 * https://leetcode.cn/contest/weekly-contest-321/problems/count-subarrays-with-median-k/
 * 2488. 统计中位数为 K 的子数组 显示英文描述
 * 通过的用户数1079
 * 尝试过的用户数2128
 * 用户总通过次数1232
 * 用户总提交次数4773
 * 题目难度Hard
 * 给你一个长度为 n 的数组 nums ，该数组由从 1 到 n 的 不同 整数组成。另给你一个正整数 k 。
 *
 * 统计并返回 num 中的 中位数 等于 k 的非空子数组的数目。
 *
 * 注意：
 *
 * 数组的中位数是按 递增 顺序排列后位于 中间 的那个元素，如果数组长度为偶数，则中位数是位于中间靠 左 的那个元素。
 * 例如，[2,3,1,4] 的中位数是 2 ，[8,4,3,5,1] 的中位数是 4 。
 * 子数组是数组中的一个连续部分。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,1,4,5], k = 4
 * 输出：3
 * 解释：中位数等于 4 的子数组有：[4]、[4,5] 和 [1,4,5] 。
 * 示例 2：
 *
 * 输入：nums = [2,3,1], k = 3
 * 输出：1
 * 解释：[3] 是唯一一个中位数等于 3 的子数组。
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i], k <= n
 * nums 中的整数互不相同
 * @author lvrui
 */
public class CountSubarrays {
    public int countSubarrays(int[] nums, int k) {


        return 9;

    }

//    public:
//    int countSubarrays(vector<int>& nums, int k) {
//        int n = nums.size();
//        int id = -1;
//        for(int i = 0;i < n; i++) {
//            if(nums[i]>k){
//                nums[i] = 1;
//            } else if(nums[i]<k) {
//                nums[i] = -1;
//            } else {
//                nums[i] = 0, id = i;
//            }
//        }
//        unordered_map<int,int> dict;
//        int prefix = 0;
//        for(int i = id; i>=0; i--) {
//            prefix+=nums[i];
//            dict[prefix]++;
//        }
//        int ans = 0;
//        prefix = 0;
//        for(int i = id; i < n; i++) {
//            prefix+=nums[i];
//            if(dict.find(-prefix)!=dict.end()) {
//                ans+=dict[-prefix];
//            }
//            if(dict.find(1-prefix)!=dict.end()) {
//                ans+=dict[1-prefix];
//            }
//        }
//        return ans;
//    }
}
