package com.pmb.code.basic.bfs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/word-transformer-lcci/submissions/
 * @author lvrui
 */
public class FindLadders {
    LinkedList<String> ans;
    Set<String> validNodes;
    Map<String, Set<String>> edges;
    List<String> starts;

    public FindLadders() {
        this.ans = new LinkedList<>();
        this.starts = new ArrayList<>();
        this.edges = new HashMap<>();
        this.validNodes = new HashSet<>();
    }

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        try {
            build(beginWord, endWord, wordList);

            LinkedList<String> path = new LinkedList<>();
            Set<String> visited = new HashSet();

            for (String start : this.starts) {

                dfs(start, endWord, path, visited);

                if (!this.ans.isEmpty()) {
                    if (!ans.getFirst().equals(beginWord)) {
                        ans.addFirst(beginWord);
                    }
                    break;
                }
            }

        } catch (Exception e) {

        }
        return ans;
    }


    private void build(String beginWord, String endWord, List<String> wordList) {

        this.validNodes.addAll(wordList.stream().collect(Collectors.toSet()));

        if (!validNodes.contains(endWord)) {
            throw new RuntimeException("invalid params");
        }

        for (int i = 0; i < wordList.size(); i++) {
            if (canTransfer(beginWord, wordList.get(i))) {
                this.starts.add(wordList.get(i));
                System.out.println(wordList.get(i));
            }
            for (int j = i + 1; j < wordList.size(); j++) {
                if (canTransfer(wordList.get(i), wordList.get(j))) {
                    Set<String> edge = new HashSet<>();
                    Set<String> cur = this.edges.getOrDefault(wordList.get(i), edge);
                    cur.add(wordList.get(j));
                    this.edges.put(wordList.get(i), cur);


                    Set<String> edge2 = new HashSet<>();
                    Set<String> cur2 = this.edges.getOrDefault(wordList.get(j), edge2);
                    cur2.add(wordList.get(i));
                    this.edges.put(wordList.get(j), cur2);
                }
            }
        }
    }

    private boolean canTransfer(String s1, String s2) {
        int mods = 0;
        int l1 = s1.length();
        int l2 = s2.length();

        boolean ans = l1 == l2;


        for (int i = 0; i < l1 && mods <= 1 && ans; i++) {

            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            } else {
                mods++;
                if (mods == 2) {
                    ans = false;
                }

            }


        }

        return ans;
    }

    private void dfs(String cur, String end, LinkedList<String> path, Set<String> visited) {
        if (end.equals(cur)) {
            path.addLast(cur);
            this.ans = new LinkedList(path);
            return;
        }

        if (!visited.add(cur)) {
            return;
        }
        Set<String> es = this.edges.get(cur);
        if (es == null) {
            return;
        }
        path.addLast(cur);

        for (String edge : es) {

            dfs(edge, end, path, visited);
            if (!this.ans.isEmpty()) {
                break;
            }
        }
        path.removeLast();


    }
}
