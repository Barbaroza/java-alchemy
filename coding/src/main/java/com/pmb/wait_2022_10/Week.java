package com.pmb.wait_2022_10;

import com.pmb.code.model.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lvrui
 */
public class Week {

    /**
     * 6220. 可被三整除的偶数的平均值 显示英文描述
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Easy
     * 给你一个由正整数组成的整数数组 nums ，返回其中可被 3 整除的所有偶数的平均值。
     * <p>
     * 注意：n 个元素的平均值等于 n 个元素 求和 再除以 n ，结果 向下取整 到最接近的整数。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,3,6,10,12,15]
     * 输出：9
     * 解释：6 和 12 是可以被 3 整除的偶数。(6 + 12) / 2 = 9 。
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,4,7,10]
     * 输出：0
     * 解释：不存在满足题目要求的整数，所以返回 0 。
     *
     * @param nums
     * @return
     */
    public int averageValue(int[] nums) {
        int sum = 0;
        int cnt = 0;
        if (nums != null) {
            for (int i : nums) {
                if (i % 6 == 0) {
                    sum += i;
                    cnt++;
                }
            }
        }
        return sum == 0 ? 0 : sum / cnt;
    }


    /**
     * 6221. 最流行的视频创作者 显示英文描述
     * 通过的用户数0
     * 尝试过的用户数0
     * 用户总通过次数0
     * 用户总提交次数0
     * 题目难度Medium
     * 给你两个字符串数组 creators 和 ids ，和一个整数数组 views ，所有数组的长度都是 n 。平台上第 i 个视频者是 creator[i] ，视频分配的 id 是 ids[i] ，且播放量为 views[i] 。
     * <p>
     * 视频创作者的 流行度 是该创作者的 所有 视频的播放量的 总和 。请找出流行度 最高 创作者以及该创作者播放量 最大 的视频的 id 。
     * <p>
     * 如果存在多个创作者流行度都最高，则需要找出所有符合条件的创作者。
     * 如果某个创作者存在多个播放量最高的视频，则只需要找出字典序最小的 id 。
     * 返回一个二维字符串数组 answer ，其中 answer[i] = [creatori, idi] 表示 creatori 的流行度 最高 且其最流行的视频 id 是 idi ，可以按任何顺序返回该结果。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：creators = ["alice","bob","alice","chris"], ids = ["one","two","three","four"], views = [5,10,5,4]
     * 输出：[["alice","one"],["bob","two"]]
     * 解释：
     * alice 的流行度是 5 + 5 = 10 。
     * bob 的流行度是 10 。
     * chris 的流行度是 4 。
     * alice 和 bob 是流行度最高的创作者。
     * bob 播放量最高的视频 id 为 "two" 。
     * alice 播放量最高的视频 id 是 "one" 和 "three" 。由于 "one" 的字典序比 "three" 更小，所以结果中返回的 id 是 "one" 。
     * 示例 2：
     * <p>
     * 输入：creators = ["alice","alice","alice"], ids = ["a","b","c"], views = [1,2,2]
     * 输出：[["alice","b"]]
     * 解释：
     * id 为 "b" 和 "c" 的视频都满足播放量最高的条件。
     * 由于 "b" 的字典序比 "c" 更小，所以结果中返回的 id 是 "b" 。
     *
     * @param creators
     * @param ids
     * @param views
     * @return
     */
    public List<List<String>> mostPopularCreator2(String[] creators, String[] ids, int[] views) {
        long max = 0;
        HashMap<String, PriorityQueue<Integer>> map = new HashMap<>();
        HashMap<String, Long> count = new HashMap<>();
        for (int i = 0; i < creators.length; i++) {
            map.computeIfAbsent(creators[i], t -> new PriorityQueue<>(
                    (o, p) -> views[o] == views[p] ? ids[o].compareTo(ids[p]) : views[p] - views[o])).offer(i);
            count.put(creators[i], count.getOrDefault(creators[i], 0L) + views[i]);
            max = Math.max(max, count.get(creators[i]));
        }
        ArrayList<List<String>> list = new ArrayList<>();
        for (Map.Entry<String, Long> entry : count.entrySet()) {
            if (entry.getValue() == max) {
                List<String> sub = new ArrayList<>();
                sub.add(entry.getKey());
                sub.add(ids[map.get(entry.getKey()).peek()]);
                list.add(sub);
            }
        }
        return list;
    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        if (creators == null || ids == null || views == null) {
            return null;
        }
        Map<String, Creator> creatorMap = new HashMap<>();
        for (int i = 0; i < creators.length; i++) {
            Creator creator = creatorMap.getOrDefault(creators[i], new Creator());
            creator.creator = creators[i];
            creator.viewsSum += views[i];
            creator.ids.add(ids[i]);
            creator.viewsSub.add(views[i]);
            creatorMap.put(creator.creator, creator);
        }

        List<Creator> collect = creatorMap.values().stream().sorted((o1, o2) -> {
            int c = o1.viewsSum - o2.viewsSum;
            return -c == 0 ? o1.creator.compareTo(o2.creator) : -c;
        }).collect(Collectors.toList());
        List<List<String>> res = new ArrayList<>();

        int pre = -1;
        for (int i = 0; i < collect.size(); i++) {
            Creator creator = collect.get(i);
            if (i == 0 || creator.viewsSum == pre) {

                int size = creator.ids.size();

                List<Integer> index = new ArrayList<>(size);

                for (int n = 0; n < size; n++) {
                    index.add(n);
                }


                Integer viewId = index.stream().sorted((i1, i2) -> {
                    int c = creator.viewsSub.get(i1) - creator.viewsSub.get(i2);
                    return -c == 0 ? creator.ids.get(i1).compareTo(creator.ids.get(i2)) : -c;
                }).findFirst().get();

                List<String> subRes = new ArrayList<>();
                subRes.add(creator.creator);
                subRes.add(creator.ids.get(viewId));
                res.add(subRes);

                pre = creator.viewsSum;
            } else {
                break;
            }

        }


        return res;
    }


    class Creator {
        private String creator;
        private int viewsSum = 0;
        private List<String> ids = new ArrayList<>();
        private List<Integer> viewsSub = new ArrayList<>();
    }


    /**
     * https://leetcode.cn/problems/minimum-addition-to-make-integer-beautiful/
     * 6222. 美丽整数的最小增量
     * 中等
     * 0
     * 相关企业
     * 给你两个正整数 n 和 target 。
     * <p>
     * 如果某个整数每一位上的数字相加小于或等于 target ，则认为这个整数是一个 美丽整数 。
     * <p>
     * 找出并返回满足 n + x 是 美丽整数 的最小非负整数 x 。生成的输入保证总可以使 n 变成一个美丽整数。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 16, target = 6
     * 输出：4
     * 解释：最初，n 是 16 ，且其每一位数字的和是 1 + 6 = 7 。在加 4 之后，n 变为 20 且每一位数字的和变成 2 + 0 = 2 。可以证明无法加上一个小于 4 的非负整数使 n 变成一个美丽整数。
     * 示例 2：
     * <p>
     * 输入：n = 467, target = 6
     * 输出：33
     * 解释：最初，n 是 467 ，且其每一位数字的和是 4 + 6 + 7 = 17 。在加 33 之后，n 变为 500 且每一位数字的和变成 5 + 0 + 0 = 5 。可以证明无法加上一个小于 33 的非负整数使 n 变成一个美丽整数。
     * 示例 3：
     * <p>
     * 输入：n = 1, target = 1
     * 输出：0
     * 解释：最初，n 是 1 ，且其每一位数字的和是 1 ，已经小于等于 target 。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 1012
     * 1 <= target <= 150
     * 生成的输入保证总可以使 n 变成一个美丽整数。
     *
     * @param n
     * @param target
     * @return
     */
    public long makeIntegerBeautiful(long n, int target) {
        long res = 0;
        long mod = 10;
        while (check(n, target)) {
            long t = mod - (n % mod);
            n += t;
            res += t;
            mod *= 10;
        }
        return res;
    }

    public boolean check(long n, int target) {
        long sum = 0;
        while (n != 0) {
            long t = n % 10;
            sum += t;
            n /= 10;
        }

        return sum > target;
    }

    public long makeIntegerBeautiful2(long n, int target) {
        long result = 0;
        for (long i = 1; ("" + n).chars().map(o -> o - '0').sum() > target; i *= 10) {
            result += i * (10 - n / i % 10);
            n += i * (10 - n / i % 10);
        }
        return result;
    }

    /**
     * 6223. 移除子树后的二叉树高度
     * 困难
     * 0
     * 相关企业
     * 给你一棵 二叉树 的根节点 root ，树中有 n 个节点。每个节点都可以被分配一个从 1 到 n 且互不相同的值。另给你一个长度为 m 的数组 queries 。
     * <p>
     * 你必须在树上执行 m 个 独立 的查询，其中第 i 个查询你需要执行以下操作：
     * <p>
     * 从树中 移除 以 queries[i] 的值作为根节点的子树。题目所用测试用例保证 queries[i] 不 等于根节点的值。
     * 返回一个长度为 m 的数组 answer ，其中 answer[i] 是执行第 i 个查询后树的高度。
     * <p>
     * 注意：
     * <p>
     * 查询之间是独立的，所以在每个查询执行后，树会回到其 初始 状态。
     * 树的高度是从根到树中某个节点的 最长简单路径中的边数 。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：root = [1,3,4,2,null,6,5,null,null,null,null,null,7], queries = [4]
     * 输出：[2]
     * 解释：上图展示了从树中移除以 4 为根节点的子树。
     * 树的高度是 2（路径为 1 -> 3 -> 2）。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：root = [5,8,9,2,1,3,7,4,6], queries = [3,2,4,8]
     * 输出：[3,2,3,2]
     * 解释：执行下述查询：
     * - 移除以 3 为根节点的子树。树的高度变为 3（路径为 5 -> 8 -> 2 -> 4）。
     * - 移除以 2 为根节点的子树。树的高度变为 2（路径为 5 -> 8 -> 1）。
     * - 移除以 4 为根节点的子树。树的高度变为 3（路径为 5 -> 8 -> 2 -> 6）。
     * - 移除以 8 为根节点的子树。树的高度变为 2（路径为 5 -> 9 -> 3）。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 树中节点的数目是 n
     * 2 <= n <= 105
     * 1 <= Node.val <= n
     * 树中的所有值 互不相同
     * m == queries.length
     * 1 <= m <= min(n, 104)
     * 1 <= queries[i] <= n
     * queries[i] != root.val
     *
     * @return
     */

    public static void main(String[] args) {
        Week w = new Week();
        w.makeIntegerBeautiful(467, 6);
    }

    int getHeight(TreeNode root, Map<Integer, Integer> hMap, Map<Integer, Integer> fat, Map<Integer, TreeNode> nodeMap, int last) {
        if (root == null) {
            return 0;
        }
        int curH = 0;
        fat.put(root.val, last);
        nodeMap.put(root.val, root);
        curH = max(curH, getHeight(root.left, hMap, fat, nodeMap, root.val));
        curH = max(curH, getHeight(root.right, hMap, fat, nodeMap, root.val));

        hMap.put(root.val, curH + 1);
        return curH + 1;
    }

    void getRet(TreeNode root, Map<Integer, Integer> hMap, Map<Integer, Integer> retMap, int leftH, int curH) {
        if (root == null) {
            return;
        }
        retMap.put(root.val, leftH);
        int lH = (root.left == null) ? curH : hMap.get(root.left.val) + curH;
        int rH = (root.right == null) ? curH : hMap.get(root.right.val) + curH;
        getRet(root.left, hMap, retMap, max(rH, leftH), curH + 1);
        getRet(root.right, hMap, retMap, max(lH, leftH), curH + 1);
    }

    int max(int a, int b) {
        return a > b ? a : b;
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = queries.length;
        Map<Integer, Integer> hMap = new HashMap<>();
        Map<Integer, Integer> fat = new HashMap<>();
        Map<Integer, TreeNode> nM = new HashMap<>();
        Map<Integer, Integer> retM = new HashMap<>();
        getHeight(root, hMap, fat, nM, -1);
        getRet(root, hMap, retM, 0, 1);
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = retM.get(queries[i]) - 1;
        }
        return ret;
    }

    public int[] treeQueries2(TreeNode root, int[] queries) {
        int[] h = new int[100001], ans = new int[100001], result = new int[queries.length];
        treeQueries(h, root);
        treeQueries(root, 0, 0, h, ans);
        for (int i = 0; i < queries.length; i++) {
            result[i] = ans[queries[i]];
        }
        return result;
    }

    private int treeQueries(int[] h, TreeNode root) {
        return root == null ? 0 : (h[root.val] = 1 + Math.max(treeQueries(h, root.left), treeQueries(h, root.right)));
    }

    private void treeQueries(TreeNode root, int max, int l, int[] h, int[] ans) {
        if (root != null) {
            ans[root.val] = Math.max(max, l - 1);
            treeQueries(root.left, Math.max(max, root.right == null ? 0 : l + h[root.right.val]), l + 1, h, ans);
            treeQueries(root.right, Math.max(max, root.left == null ? 0 : l + h[root.left.val]), l + 1, h, ans);
        }
    }

}
