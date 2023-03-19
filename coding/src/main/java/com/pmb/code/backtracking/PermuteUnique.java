package com.pmb.code.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**https://leetcode.cn/problems/7p8L0Z/submissions/
 * @author lvrui
 * [[0,0,0,1,9],[0,0,0,9,1],[0,0,1,0,9],[0,0,1,9,0],[0,0,9,1,0],[0,0,9,0,1],[0,1,0,0,9],[0,1,0,9,0],[0,1,9,0,0],[0,9,0,1,0],[0,9,0,0,1],[0,9,1,0,0],[0,9,0,1,0],[0,9,0,0,1],[1,0,0,0,9],[1,0,0,9,0],[1,0,9,0,0],[1,9,0,0,0],[9,0,0,1,0],[9,0,0,0,1],[9,0,1,0,0],[9,0,0,1,0],[9,0,0,0,1],[9,1,0,0,0],[9,0,0,1,0],[9,0,0,0,1],[9,0,1,0,0],[9,0,0,1,0],[9,0,0,0,1]]
 * [[0,0,0,1,9],[0,0,0,9,1],[0,0,1,0,9],[0,0,1,9,0],[0,0,9,0,1],[0,0,9,1,0],[0,1,0,0,9],[0,1,0,9,0],[0,1,9,0,0],[0,9,0,0,1],[0,9,0,1,0],[0,9,1,0,0],[1,0,0,0,9],[1,0,0,9,0],[1,0,9,0,0],[1,9,0,0,0],[9,0,0,0,1],[9,0,0,1,0],[9,0,1,0,0],[9,1,0,0,0]]
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();

        bt(0, nums, nums.length, ans);

        return ans;
    }

    private void bt(int start, int[] nums, int rem, List<List<Integer>> ans) {

        if (rem == 0) {
            ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            int t = nums[start];
            nums[start] = nums[i];
            nums[i] = t;
            bt(start + 1, nums, rem - 1, ans);
            nums[i] = nums[start];
            nums[start] = t;

        }
    }

    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        permuteUnique.permuteUnique(new int[]{1, 1, 2});
    }
}
