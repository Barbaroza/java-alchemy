package com.pmb.code.datastructure.tree.BTS;

import com.pmb.code.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树迭代器
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * <p>
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 * <p>
 * <p>
 * 提示：
 * <p>
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 *
 * @author lvrui
 */
public class BSTIterator {
    private List<Integer> temp;
    private Integer index;

    public BSTIterator(TreeNode root) {
        temp = new ArrayList<>();
        index = 0;
        buildTree(root);
    }

    private void buildTree(TreeNode root) {
        if (root != null) {
            buildTree(root.left);
            temp.add(root.val);
            buildTree(root.right);
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        Integer res = temp.get(index);
        index++;
        return res;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return index < temp.size();
    }
}
