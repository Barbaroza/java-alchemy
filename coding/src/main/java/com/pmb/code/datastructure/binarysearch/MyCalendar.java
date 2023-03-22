package com.pmb.code.datastructure.binarysearch;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.cn/problems/fi9suh/
 *
 * @author lvrui
 */
public class MyCalendar {
    private TreeMap<Integer, Integer> map = null;

    public MyCalendar() {
        map = new TreeMap<>((a, b) -> a - b);
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> floorEntry = map.floorEntry(start);
        Map.Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(start);

        if(floorEntry!=null){
            if(floorEntry.getValue()>start)return false;
        }
        if(ceilingEntry!=null){
            if(ceilingEntry.getKey()<end)return false;
        }
        map.put(start, end);
        return true;
    }

    class TreeNode{
        TreeNode left;
        TreeNode right;
        int start;
        int end;
        public TreeNode(int start, int end){
            this.start = start;
            this.end = end;
        }
        public TreeNode(){
        }
    }

    TreeNode root;


    public boolean book2(int start, int end) {
        if(root == null){
            root = new TreeNode(start, end);
            return true;
        }
        // 类似二分搜索BST
        TreeNode p = root;
        

        while(p!=null) {
            if(end <= p.start) {
                // 该区间应该在当前节点的左子树
                if(p.left==null) {
                    //若是左子树为空，那这就是应该加入的位置
                    p.left = new TreeNode(start, end);
                    return true;
                }
                p = p.left;
            }else if(start >= p.end) {
                // 同理，该区间应该在该节点的右子树
                if(p.right==null) {
                    p.right = new TreeNode(start, end);
                    return true;
                }
                p = p.right;
            }else {
                return false;
            }
        }
        return false;
    }


}
