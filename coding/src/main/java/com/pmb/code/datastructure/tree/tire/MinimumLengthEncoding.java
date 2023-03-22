package com.pmb.code.datastructure.tree.tire;

/**
 * https://leetcode.cn/problems/iSwD2y/
 *
 * @author lvrui
 */
public class MinimumLengthEncoding {
    public int minimumLengthEncoding(String[] words) {
        TireNode root = buildTree(words);
        return count(root, 1);
    }


    TireNode buildTree(String[] words) {
        TireNode root = new TireNode();

        for (String word : words) {
            TireNode cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                int key = word.charAt(i) - 'a';
                cur.next[key] = cur.next[key] == null ? new TireNode(key) : cur.next[key];
                cur = cur.next[key];

            }
        }
        return root;
    }

    int count(TireNode root, int l) {
        if (root == null) {
            return 0;
        }
        int cntSum = 0;
        for (TireNode node : root.next) {
            int cnt = count(node, l + 1);
            if (cnt != 0) {
                cntSum += (cnt);
            }
        }

        return cntSum == 0 ? l : cntSum;
    }

    public static class TireNode {
        int val;
        TireNode[] next;

        public TireNode() {
            this.next = new TireNode[26];
        }

        public TireNode(int val) {
            this.next = new TireNode[26];
            this.val = val;
        }
    }
}
