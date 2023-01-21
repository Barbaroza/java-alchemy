package com.pmb.wait_2022_11_03;

import com.pmb.code.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**https://leetcode.cn/problems/closest-nodes-queries-in-a-binary-search-tree/
 * @author lvrui
 */
public class ClosestNodes {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> res = new ArrayList<>(queries.size());
        queries.forEach(q -> {
            int[] minMax = new int[2];
            minMax[0] = -1;
            minMax[1] = -1;
            binSearch(root, q, minMax);

            List<Integer> subResult = new ArrayList<Integer>();
            subResult.add(minMax[0]);
            subResult.add(minMax[1]);
            res.add(subResult);
        });
        return res;
    }

    private void binSearch(TreeNode root, Integer q, int[] minMax) {
        if (root == null) {
            return;
        }
        if (root.val == q) {
            minMax[0] = q;
            minMax[1] = q;

            return;
        }
        if (root.val > q) {
            minMax[1] = root.val;
            binSearch(root.left, q, minMax);
        } else {
            minMax[0] = root.val;
            binSearch(root.right, q, minMax);
        }
    }

    TreeSet<Integer> set;

    public List<List<Integer>> closestNodes2(TreeNode root, List<Integer> queries) {
        set = new TreeSet<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(root);
        for (Integer query : queries) {
            Integer floor = set.floor(query);
            Integer ceiling = set.ceiling(query);
            List<Integer> temp = new ArrayList<>();
            if (floor == null) temp.add(-1);
            else temp.add(floor);
            if (ceiling == null) temp.add(-1);
            else temp.add(ceiling);
            res.add(temp);
        }
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        set.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

}
