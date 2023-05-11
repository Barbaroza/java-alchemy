package com.pmb.code.dp;

import com.pmb.code.basic.prefix.Solution;

import java.util.Arrays;

/**
 *
 * https://leetcode.cn/problems/re-space-lcci/solution/hui-fu-kong-ge-by-leetcode-solution/
 * @author lvrui
 */
public class Respace {
    public int respace(String[] dictionary, String sentence) {
        if(sentence == null || sentence.length() == 0){
            return 0;
        }

        TrieNode vNode = build(dictionary);

        char[] chars = sentence.toCharArray();
        int[] dp = new int[chars.length+1];


        dp(dp,chars,vNode);

        return dp[0];


    }

    private void dp(int[] dp,char[]chars,TrieNode vNode){
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[dp.length-1] = 0;
        for(int i = dp.length-2;i>=0;i--){
            TrieNode cur = vNode;
            for(int j = i;j<dp.length-1;j++){
                cur = cur.next[chars[j]-'a'];
                if(cur == null){
                    break;
                }
                if(cur.isEnd){
                    dp[i] = Math.min(dp[j+1],dp[i]);
                }
            }
            dp[i] = Math.min(dp[i],dp[i+1]+1);
        }
    }

    private TrieNode build(String[] dictionary){
        TrieNode vNode = new TrieNode(-1);

        for(int i = 0; i < dictionary.length;i++){
            TrieNode pre = vNode;
            char[] chars = dictionary[i].toCharArray();
            for(int j = 0; j< chars.length;j++){
                int v = chars[j] - 'a';
                if(pre.next[v] == null){
                    pre.next[v] = new TrieNode(v);

                }
                pre = pre.next[v];

                if(j == chars.length -1){
                    pre.isEnd = true;
                }
            }

        }

        return vNode;
    }


    public static class TrieNode {
        int val;
        TrieNode[] next;
        boolean isEnd;
        public TrieNode(int val){
            this.val = val;
            next = new TrieNode[26];
        }

    }


    public int respace2(String[] dictionary, String sentence) {
        int n = sentence.length();

        Trie root = new Trie();
        for (String word: dictionary) {
            root.insert(word);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] + 1;

            Trie curPos = root;
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a';
                if (curPos.next[t] == null) {
                    break;
                } else if (curPos.next[t].isEnd) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) {
                    break;
                }
                curPos = curPos.next[t];
            }
        }
        return dp[n];
    }
}

class Trie {
    public Trie[] next;
    public boolean isEnd;

    public Trie() {
        next = new Trie[26];
        isEnd = false;
    }

    public void insert(String s) {
        Trie curPos = this;

        for (int i = s.length() - 1; i >= 0; --i) {
            int t = s.charAt(i) - 'a';
            if (curPos.next[t] == null) {
                curPos.next[t] = new Trie();
            }
            curPos = curPos.next[t];
        }
        curPos.isEnd = true;
    }


}
