package com.pmb.wait.wait_2022_11_02;

import com.pmb.code.model.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 6235. 逐层排序二叉树所需的最少操作数目 显示英文描述
 * 通过的用户数36
 * 尝试过的用户数64
 * 用户总通过次数36
 * 用户总提交次数69
 * 题目难度Medium
 * 给你一个 值互不相同 的二叉树的根节点 root 。
 * <p>
 * 在一步操作中，你可以选择 同一层 上任意两个节点，交换这两个节点的值。
 * <p>
 * 返回每一层按 严格递增顺序 排序所需的最少操作数目。
 * <p>
 * 节点的 层数 是该节点和根节点之间的路径的边数。
 * <p>
 * <p>
 * <p>
 * 示例 1 ：
 * <p>
 * <p>
 * 输入：root = [1,4,3,7,6,8,5,null,null,null,null,9,null,10]
 * 输出：3
 * 解释：
 * - 交换 4 和 3 。第 2 层变为 [3,4] 。
 * - 交换 7 和 5 。第 3 层变为 [5,6,8,7] 。
 * - 交换 8 和 7 。第 3 层变为 [5,6,7,8] 。
 * 共计用了 3 步操作，所以返回 3 。
 * 可以证明 3 是需要的最少操作数目。
 * 示例 2 ：
 * <p>
 * <p>
 * 输入：root = [1,3,2,7,6,5,4]
 * 输出：3
 * 解释：
 * - 交换 3 和 2 。第 2 层变为 [2,3] 。
 * - 交换 7 和 4 。第 3 层变为 [4,6,5,7] 。
 * - 交换 6 和 5 。第 3 层变为 [4,5,6,7] 。
 * 共计用了 3 步操作，所以返回 3 。
 * 可以证明 3 是需要的最少操作数目。
 * 示例 3 ：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6]
 * 输出：0
 * 解释：每一层已经按递增顺序排序，所以返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [1, 105] 。
 * 1 <= Node.val <= 105
 * 树中的所有值 互不相同 。
 *
 * @author lvrui
 */
public class MinimumOperations {
    public int minimumOperations(TreeNode root) {

        Deque<TreeNode> deque = new LinkedList<>();

        deque.addFirst(root);
        int cnt = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            int[] o = new int[size];
            while (size > 0) {

                TreeNode f = deque.poll();
                o[o.length - size] = f.val;
                if (f.left != null) {
                    deque.addLast(f.left);
                }
                if (f.right != null) {
                    deque.addLast(f.right);
                }
                size--;
            }

            cnt += swapCounter(o);
        }

        return cnt;

    }

    public int swapCounter(int[] o) {
        Integer[] sio = new Integer[o.length];
        Integer[] oi = new Integer[o.length];
        for (int i = 0; i < o.length; i++) {
            oi[i] = i;
        }
        System.arraycopy(oi, 0, sio, 0, o.length);

        Arrays.sort(sio, (o1, o2) -> o[o1] - o[o2]);
        int cnt = 0;
        for (int i = 0; i < o.length; i++) {
            if (!Objects.equals(sio[i], oi[i])) {
                Integer t = oi[sio[i]];
                oi[sio[i]] = oi[i];
                oi[i] = t;
                cnt++;

            }




    }

        return cnt;
}


    public static void main(String[] args) {
        MinimumOperations minimumOperations = new MinimumOperations();
        minimumOperations.swapCounter(new int[]{4, 0, 2, 3, 1});
    }
}
