package com.pmb.code.datastructure.graph;

/**
 * @author lvrui
 */
public class FindCircleNum {
    public int findCircleNum(int[][] isConnected) {
        int cnt = 0;

        if(isConnected == null || isConnected.length == 0 || isConnected[0] == null || isConnected[0].length == 0){
            return cnt;
        }

        int n =  isConnected.length;
        boolean[] visit = new boolean[n];
        for(int i = 0;i<n;i++){
            if(visit[i]){
                continue;
            }
            cnt++;
            dfs(visit,isConnected,i);

        }
        return cnt;
    }

    private void dfs(boolean[] visit , int[][] isConnected,int index){
        if(visit[index]){
            return;
        }

        visit[index] = true;

        for(int i = 0 ;i<isConnected[index].length;i++){
            if(isConnected[index][i] == 1){
                dfs(visit,isConnected,i);
            }
        }
    }
}
