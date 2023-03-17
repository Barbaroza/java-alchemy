package com.pmb.code.datastructure.tree.tire;

/**
 *
 * @author lvrui
 */
public class MapSum {
    private TireNode vNode;
    public MapSum() {
        TireNode vNode = new TireNode();
    }

    public void insert(String key, int val) {
        TireNode cur = this.vNode;
        for(int i = 0 ;i<key.length();i++){
            int keyNum = key.charAt(i)-'a';
            TireNode next = null;
            if(i<key.length()-1){
                cur.next[keyNum] = cur.next[keyNum] == null? new TireNode():cur.next[keyNum];
            }else{
                cur.next[keyNum] = cur.next[keyNum] == null? new TireNode():cur.next[keyNum];
                cur.next[keyNum].isEnd = true;
                cur.next[keyNum].val = val;
            }
            next = cur.next[keyNum];
            cur = next;
        }
    }

    public int sum(String prefix) {
        int ans = 0;
        TireNode cur = vNode;

        for(int i = 0 ;i<prefix.length();i++){
            int key = prefix.charAt(i) -'a';
            cur = cur.next[key];
            if(cur == null){
                return ans;
            }
        }
        return dfs(cur);
    }


    private int dfs(TireNode cur){
        if(cur == null){
            return 0;
        }
        int sum = cur.isEnd ? cur.val : 0;
        for(TireNode node : cur.next){
            sum+=dfs(node);
        }

        return sum;

    }


    public static class TireNode{
        int val;
        boolean isEnd;
        TireNode [] next;
        public TireNode(){
            next = new TireNode[26];
            isEnd = false;
        }
        public TireNode(int val , boolean isEnd){
            next = new TireNode[26];
            val = val;
            isEnd = isEnd;
        }
    }
}
