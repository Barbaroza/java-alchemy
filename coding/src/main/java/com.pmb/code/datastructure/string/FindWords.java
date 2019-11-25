package com.pmb.code.datastructure.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单词搜索 II
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * <p>
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 * <p>
 * 提示:
 * <p>
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 *
 * @author lvrui
 */
public class FindWords {

    public List<String> findWords(char[][] board, String[] words) {
        TireTree tree = new TireTree();

        for (String str : words) {
            tree.insert(str);
        }
        List<String> resList = new ArrayList<>();
        boolean[][] flags = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                search(null, board, i, j, resList, flags, tree);
            }
        }
        return resList;
    }

    private void search(TreeNode o, char[][] board, int i, int j, List<String> resList, boolean[][] flags, TireTree tree) {
        if (flags[i][j] || i < 0 || j < 0 || i >= board.length || j >= board[i].length) {
            return;
        }
        TreeNode treeNode = tree.find(String.valueOf(board[i][j]), o);
        if (treeNode == null) {
            return;
        }
        if (treeNode.isTail) {
            resList.add(treeNode.word);
        }
        flags[i][j] = true;
        search(treeNode, board, i - 1, j, resList, flags, tree);
        search(treeNode, board, i + 1, j, resList, flags, tree);
        search(treeNode, board, i, j + 1, resList, flags, tree);
        search(treeNode, board, i, j - 1, resList, flags, tree);
        flags[i][j] = false;
    }

    public class TreeNode {
        private boolean isString;
        private Map<String, TreeNode> map;
        private boolean isTail;
        private String word;

        public TreeNode() {
            this.isString = false;
            map = new HashMap<>(32);
            isTail = false;
        }
    }

    public class TireTree {
        private TreeNode root;

        TireTree() {
            root = new TreeNode();
        }

        void insert(String word) {
            TreeNode current = this.root;
            for (int i = 0; i < word.length(); i++) {
                char k = word.charAt(i);
                TreeNode treeNode = current.map.get(String.valueOf(k));
                if (treeNode == null) {
                    treeNode = new TreeNode();
                    current.map.put(String.valueOf(k), treeNode);
                }
                current = treeNode;
                if (i == word.length() - 1) {
                    treeNode.isTail = true;
                    treeNode.word = word;
                }
            }
        }

        TreeNode find(String word, TreeNode node) {
            TreeNode current = node == null ? this.root : node;
            for (int i = 0; i < word.length(); i++) {
                String k = String.valueOf(word.charAt(i));
                TreeNode treeNode = current.map.get(k);
                if (treeNode == null) {
                    return null;
                } else {
                    current = treeNode;
                }
            }
            return current;
        }
    }

    public static void main(String[] args) {
        FindWords findWords = new FindWords();
        findWords.findWords(new char[][]{new char[]{'a', 'b'}, new char[]{'a', 'c'}}, new String[]{"ac", "abc", "aaa", "aa"});
    }
}
