package com.pmb.code.datastructure.tree;

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
 * 说明:
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 * @author lvrui
 */
public class Trie {
    Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.root = new Node();
    }

    /**
     * ["Trie","insert","insert","insert","insert","insert","insert","search","search","search","search","search","search","search","search","search","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith"]
     * [[],["app"],["apple"],["beer"],["add"],["jam"],["rental"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"]]
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        Node temp = this.root;
        for (int index = 0; index < chars.length; index++) {
            boolean isEnd = index == (chars.length - 1);
            int key = chars[index] - 'a';

            Node node = temp.nodes[key];
            if (node != null && index != (chars.length - 1)) {
                temp = node;
            } else {
                temp = temp.put(key, chars[index], isEnd);
            }
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Node temp = this.root;
        boolean res = false;
        for (int index = 0; index < chars.length; index++) {
            Node node = temp.nodes[(chars[index] - 'a')];
            if (node == null) {
                break;
            } else {
                if (index == (chars.length - 1) && node.isEnd) {
                    res = true;
                }
                temp = node;
            }
        }
        return res;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Node temp = this.root;
        boolean res = false;
        for (int index = 0; index < chars.length; index++) {
            Node node = temp.nodes[(chars[index] - 'a')];
            if (node == null) {
                break;
            } else {
                if (index == (chars.length - 1)) {
                    res = true;
                }
                temp = node;
            }
        }
        return res;
    }

    class Node {
        boolean isEnd = false;
        char value;
        Node[] nodes = new Node[26];

        Node() {

        }

        Node(char value, boolean isEnd) {
            this.value = value;
            this.isEnd = isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        public Node put(Integer key, char val, boolean isend) {
            Node node = new Node(val, isend);
            if (this.nodes[key] == null) {

                this.nodes[key] = node;
            } else {
                this.nodes[key].isEnd = isend || this.nodes[key].isEnd;
            }
            return node;
        }
    }


    /**
     * ["Trie","insert","insert","insert","insert","insert","insert","search","search","search","search","search","search","search","search","search","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith"]
     * [[],["app"],["apple"],["beer"],["add"],["jam"],["rental"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"]]
     * [null,null,null,null,null,null,null,false,false,false,false,false,false,false,true,true,false,false,true,false,false,false,true,true,true]
     * [null,null,null,null,null,null,null,false,true,false,false,false,false,false,true,true,false,true,true,false,false,false,true,true,true]
     *
     * @param args
     */
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("appple");
        boolean appple = t.search("appple");
    }
}
