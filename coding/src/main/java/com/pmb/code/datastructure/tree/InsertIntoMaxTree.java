package com.pmb.code.datastructure.tree;

import com.pmb.code.model.TreeNode;

/**
 * 998. 最大二叉树 II
 * 最大树定义：一个树，其中每个节点的值都大于其子树中的任何其他值。
 * <p>
 * 给出最大树的根节点 root。
 * <p>
 * 就像之前的问题那样，给定的树是从表 A（root = Construct(A)）递归地使用下述 Construct(A) 例程构造的：
 * <p>
 * 如果 A 为空，返回 null
 * 否则，令 A[i] 作为 A 的最大元素。创建一个值为 A[i] 的根节点 root
 * root 的左子树将被构建为 Construct([A[0], A[1], ..., A[i-1]])
 * root 的右子树将被构建为 Construct([A[i+1], A[i+2], ..., A[A.length - 1]])
 * 返回 root
 * 请注意，我们没有直接给定 A，只有一个根节点 root = Construct(A).
 * <p>
 * 假设 B 是 A 的副本，并附加值 val。保证 B 中的值是不同的。
 * <p>
 * 返回 Construct(B)。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [4,1,3,null,null,2], val = 5
 * 输出：[5,4,null,1,3,null,null,2]
 * 解释：A = [1,4,2,3], B = [1,4,2,3,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,2,4,null,1], val = 3
 * 输出：[5,2,4,null,1,null,3]
 * 解释：A = [2,1,5,4], B = [2,1,5,4,3]
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [5,2,3,null,1], val = 4
 * 输出：[5,2,4,null,1,3]
 * 解释：A = [2,1,5,3], B = [2,1,5,3,4]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= B.length <= 100
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lvrui
 */
public class InsertIntoMaxTree {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) {
            TreeNode tn = new TreeNode(val);
            tn.left = root;
            return tn;
        }
        TreeNode parent = root;
        TreeNode tn = new TreeNode(val);
        while (parent.right != null && parent.right.val > val) parent = parent.right;
        if (parent.right == null) {
            parent.right = tn;
        } else {
            tn.left = parent.right;
            parent.right = tn;
        }
        return root;
    }


}
