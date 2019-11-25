package com.pmb.code.datastructure.string;

import java.util.Objects;

/**
 * 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 *
 * @author lvrui
 */
class Trie {

    private TrieNode root = new TrieNode();

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    class TrieNode {
        char val;
        TrieNode[] sons;
        boolean isLast;

        public TrieNode() {
            sons = new TrieNode[26];
            isLast = true;
        }

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word != null && !word.isEmpty()) {
            char[] chars = word.toCharArray();
            TrieNode currentRoot = this.root;
            for (int i = 0; i < chars.length; i++) {
                boolean islast = true;
                if (i != chars.length - 1) {
                    islast = false;
                }
                currentRoot = insert(chars[i], currentRoot, islast);
            }
        }
    }

    private TrieNode insert(char i, TrieNode root, boolean b) {
        int k = i - 'a';
        if (Objects.isNull(root.sons[k])) {
            root.sons[k] = new TrieNode();
            root.sons[k].val = i;
            if (b) {
                root.sons[k].isLast = true;
            } else {
                root.sons[k].isLast = false;
            }
        }
        return root.sons[k];
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word != null && !word.isEmpty()) {
            char[] chars = word.toCharArray();
            TrieNode currentRoot = this.root;

            for (int i = 0; i < chars.length; i++) {
                int k = chars[i] - 'a';
                if (currentRoot.sons[k] == null) {
                    return false;
                } else {
                    if (i == chars.length - 1) {
                        if (currentRoot.isLast) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    currentRoot = currentRoot.sons[k];
                }
            }
        }
        return false;
    }


    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix != null && !prefix.isEmpty()) {
            char[] chars = prefix.toCharArray();
            TrieNode currentRoot = this.root;

            for (int i = 0; i < chars.length; i++) {
                int k = chars[i] - 'a';
                if (currentRoot.sons[k] == null) {
                    return false;
                } else {
                    if (i == chars.length - 1) {

                        return true;
                    }
                    currentRoot = currentRoot.sons[k];
                }
            }
        }
        return false;
    }


    /**
     * ["Trie","insert","insert","insert","insert","insert","insert","search","search","search","search","search","search","search","search","search","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith"]
     * [[],["app"],["apple"],["beer"],["add"],["jam"],["rental"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"]]
     *
     * @param args
     */
    public static void main(String[] args) {

        Trie t = new Trie();
        t.insert("app");
        t.insert("apple");
//        t.insert("beer");
//        t.insert("add");
        t.insert("ja");

        t.insert("jam");
        t.insert("rental");
        boolean c = t.search("jam");

        boolean a = t.startsWith("eer");
        boolean b = t.startsWith("re");
        int asdsaa = 0;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
