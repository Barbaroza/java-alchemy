package com.pmb.code.backtracking;

import java.util.List;

/**
 * @author lvrui
 */
public class Interview {

    /**
     * eg: args
     *      1
     *    2   3  ,  1  , 1
     *
     *  [2,3]
     *
     * @param root      二叉搜索树
     * @param targetVal 目标节点值
     * @param levelGap  目标节点值分支节点的层数间隔
     * @return 复合条件的节点值集合 找不到 null
     */
    public List<Integer> find(Node root, int targetVal, int levelGap) {
        return null;
    }

    class Node {
        Node right;
        Node left;
        int val;
    }
}
