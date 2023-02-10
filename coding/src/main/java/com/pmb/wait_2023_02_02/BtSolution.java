package com.pmb.wait_2023_02_02;

import java.util.*;

/**
 * @author lvrui
 */
public class BtSolution {
    private void swap(ArrayList<Integer> num, int i1, int i2) {
        int temp = num.get(i1);
        num.set(i1, num.get(i2));
        num.set(i2, temp);
    }

    public void recursion(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> num, int index) {
        if (index == num.size() - 1) {
            res.add(num);
        } else {
            for (int i = index; i < num.size(); i++) {
                //交换二者
                swap(num, i, index);
                //继续往后找
                recursion(res, num, index + 1);
                //回溯
                swap(num, i, index);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        //先按字典序排序
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        //数组转ArrayList
        for (int i = 0; i < num.length; i++)
            nums.add(num[i]);
        recursion(res, nums, 0);
        return res;
    }

    public List<List<Integer>> permute2(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }


    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        LinkedList<Integer> path2 = new LinkedList();
        bt(ans, target, candidates, 0, path);

        return ans;
    }


    private void bt(List<List<Integer>> ans, int target, int[] candidates, int start, LinkedList<Integer> path) {
        if (target == 0) {

            ans.add(new ArrayList<>(path));
            return;
        }
        if (start == candidates.length || candidates[start] > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            bt(ans, target - candidates[start], candidates, i + 1, path);
            path.removeLast();
        }

    }

    public List<List<Integer>> combinationSum22(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        int len = candidates.length;
        //数组一定要时有序的，才能进行深度递归
        Arrays.sort(candidates);
        //深度递归
        dfs(candidates, len, 0, target, path, res);
        return res;
    }

    public void dfs(int[] candidates, int len, int dept, int target, Deque<
            Integer> path, List<List<Integer>> res) {
        //如果递归到叶子结点，节点值刚好等于0，那说明路径上的元素就是结果
        if (target == 0) {
            //将路径上的结果加入返回结果集上
            res.add(new ArrayList<>(path));
            //退出递归
            return;
        }
        for (int i = dept; i < len; i++) {
            //大剪枝，如果在有序的情况下，当前元素已经大于目标数组元素
            //那说明后面的元素就不在需要遍历，原因后面的元素比当前元素更大。
            if (target - candidates[i] < 0) {
                break;
            }
            //小剪枝，发生在同层， 可以自己在图上画一个在第一个节点取1后的几种情况就可以发现
            //如果同层的元素的值，相同，就不在需要递归了，
            //原因在有序的情况下，后面出现的元素都会相同，造成结果集也会相同
            if (i > dept && candidates[i] == candidates[i - 1]) {
                continue;
            }
            //将数组的元素加入路径集合中
            path.addLast(candidates[i]);
            //进行深度递归下一层，所以i+1，
            //这边的重复，允许不同层重复，但是同层不能重复，
            dfs(candidates, len, i + 1, target - candidates[i], path, res);
            //剪枝，将元素从末尾开始删除，
            //相当于将树，从叶子结点开始向根结点删除。
            path.removeLast();

        }
    }


    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsetsWithDupHelper(nums, 0);
        return res;
    }


    private void subsetsWithDupHelper(int[] nums, int start) {
        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            // 跳过当前树层使用过的、相同的元素
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            path.add(nums[i]);
            subsetsWithDupHelper(nums, i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        LinkedList<Integer> path = new LinkedList<>();


        bt(ans, nums, path, 0);


        return ans;
    }


    private void bt(List<List<Integer>> ans, int[] nums, LinkedList<Integer> path, int start) {
        if (start == nums.length) {
            ans.add(new ArrayList<>(path));

            return;
        }

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            bt(ans, nums, path, start + 1);
            path.removeLast();


        }
    }

    public ArrayList<String> generateParenthesis(int n) {
        int l = n, r = n;

        ArrayList<String> ans = new ArrayList<String>();
        StringBuilder path = new StringBuilder();
        dfs(l, r, ans, path);


        return ans;
    }


    private void dfs(int l, int r, List<String> ans, StringBuilder path) {
        if (l == 0 && r == 0) {
            ans.add(path.toString());
            return;
        }

        if (l > 0) {
            path.append("(");
            dfs(l - 1, r, ans, path);

            path.deleteCharAt(path.length() - 1);
        }
        if (r >= l) {
            path.append(")");
            dfs(l, r - 1, ans, path);
            path.deleteCharAt(path.length() - 1);

            path.deleteCharAt(path.length() - 1);
        }


    }
}
