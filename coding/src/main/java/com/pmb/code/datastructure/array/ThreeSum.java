package com.pmb.code.datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author lvrui
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> tempMap = new ArrayList<>();
        outer:
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[r] < 0) {
                    break outer;
                }
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> arr = new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[r]);
                    arr.add(nums[l]);
                    tempMap.add(arr);
                    while (r > l && nums[l + 1] == nums[l]) l++;
                    while (r > l && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return tempMap;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                while (l < r && nums[l] == nums[l - 1]) {
                    l++;
                }
                while (r > l && r < nums.length - 1 && nums[r - 1] == nums[r]) {
                    r--;
                }

                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> t = new ArrayList();
                    t.add(nums[i]);
                    t.add(nums[l]);
                    t.add(nums[r]);
                    ans.add(t);
                    l++;
                    r--;
                }
                if (sum > 0) {
                    r--;
                }
                if (sum < 0) {
                    l++;
                }


            }

        }


        return ans;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        threeSum.threeSum2(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
