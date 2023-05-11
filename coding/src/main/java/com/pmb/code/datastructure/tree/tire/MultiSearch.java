package com.pmb.code.datastructure.tree.tire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lvrui
 */
public class MultiSearch {
    public int[][] multiSearch(String big, String[] smalls) {

        List<Integer>[] ans = new List[smalls.length];

        for(int i =0;i<ans.length;i++){
            ans[i] = new ArrayList<>();
        }
        Node root = build(smalls);
        char[] chars = big.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            List<Integer> a = search(chars, i, root);
            for (int index : a) {
                ans[index].add(i);
            }
        }

        return convert(ans);

    }

    public static class Node {
        boolean isEnd;
        Node[] next;
        int val;
        int index;

        public Node(int val) {
            this.val = val;
            this.next = new Node[26];
        }

    }

    private int[][] convert(List<Integer>[] arr) {
        int[][] ans = new int[arr.length][];

        for (int i = 0; i < arr.length; i++) {
            ans[i] = new int[arr[i].size()];
            for (int j = 0; j < arr[i].size(); j++) {
                ans[i][j] = arr[i].get(j);
            }
        }

        return ans;

    }

    private Node build(String[] keys) {
        Node root = new Node(-1);
        Node cur = root;
        int index = 0;
        for (String key : keys) {
            char[] chars = key.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int v = chars[i] - 'a';
                cur.next[v] = cur.next[v] == null ? new Node(v) : cur.next[v];
                cur = cur.next[v];
                if (i == chars.length - 1) {
                    cur.isEnd = true;
                    cur.index = index;

                }
            }
            index++;
            cur = root;
        }

        return root;
    }

    private List<Integer> search(char[] chars, int i, Node root) {
        List<Integer> res = new ArrayList<Integer>();


        if (root == null || chars == null || chars.length - 1 < i) {
            return res;
        }
        Node cur = root;
        while (i < chars.length) {
            int v = chars[i] - 'a';
            if (cur.next[v] == null) {
                break;
            }
            if (cur.next[v].isEnd) {
                res.add(cur.next[v].index);
            }
            cur = cur.next[v];
            i++;

        }

        return res;
    }

    public static void main(String[] args) {
        MultiSearch m = new MultiSearch();
        m.multiSearch("mississippi",
                new String[]{"is", "ppi", "hi", "sis", "i", "ssippi"});
    }
}
