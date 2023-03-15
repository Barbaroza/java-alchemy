package com.pmb.code.datastructure.tree;

import java.util.*;

/**
 * https://leetcode.cn/problems/UhWRSj/
 *
 * @author lvrui
 */
public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        if (sentence == null) {
            return null;
        }
        Node node = build(dictionary);

        String[] arr = sentence.split(" ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = match(arr[i], node);
        }


        return String.join(" ", arr);

    }


    public static class Node {
        Integer val;
        boolean isEnd = false;
        Map<Integer, Node> next = new HashMap();
    }

    private Node build(List<String> dics) {
        Node vRoot = new Node();

        for (String token : dics) {
            build(vRoot, token);
        }
        return vRoot;
    }

    private void build(Node root, String s) {
        if (s == null || root == null) return;
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            int key = t - 'a';
            Node next = cur.next.getOrDefault(key, new Node());
            cur.next.put(key, next);
            next.val = key;
            if (i == s.length() - 1) {
                next.isEnd = true;
            }
            cur = next;

        }

    }

    private String match(String token, Node root) {
        Node cur = root;
        StringBuilder replace = new StringBuilder();
        for (int i = 0; i < token.length(); i++) {
            int key = token.charAt(i) - 'a';
            cur = cur.next.get(key);
            if (cur != null) {
                replace.append(token.charAt(i));
                if(cur.isEnd){
                    break;
                }
            } else {
                break;
            }
        }

        if (cur != null && cur.isEnd) {
            return replace.toString();
        }

        return token;
    }

    public String replaceWords2(List<String> dictionary, String sentence) {
        Set<String> dictionarySet = new HashSet<String>();
        for (String root : dictionary) {
            dictionarySet.add(root);
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (dictionarySet.contains(word.substring(0, 1 + j))) {
                    words[i] = word.substring(0, 1 + j);
                    break;
                }
            }
        }
        return String.join(" ", words);
    }


    public static void main(String[] args) {
        ReplaceWords replaceWords = new ReplaceWords();

        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("bat");
        list.add("rat");

        replaceWords.replaceWords(list, "the cattle was rattled by the battery");
    }
}
