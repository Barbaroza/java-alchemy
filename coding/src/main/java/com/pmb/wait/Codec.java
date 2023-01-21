package com.pmb.wait;

import com.pmb.code.model.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 37. 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * @author lvrui
 */
public class Codec {

    private static final String NONE_NODE = "n";
    private static final String SEPARATOR = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            TreeNode treeNode = deque.removeLast();
            if (treeNode != null) {
                deque.addLast(treeNode.right);
                deque.addLast(treeNode.left);
            }

            res.append(treeNode == null ? NONE_NODE : treeNode.val).append(SEPARATOR);
        }

        return res.delete(res.length() - 1, res.length()).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(SEPARATOR);
        Deque<String> deque = new LinkedList<>(Arrays.asList(split));
        return convert(deque);

    }

    private TreeNode convert(Deque<String> deque) {
        if (deque.isEmpty()) {
            return null;
        }
        String nodeValue = deque.removeFirst();
        if (NONE_NODE.equals(nodeValue)) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(nodeValue));
        treeNode.left = convert(deque);
        treeNode.right = convert(deque);

        return treeNode;
    }
}
