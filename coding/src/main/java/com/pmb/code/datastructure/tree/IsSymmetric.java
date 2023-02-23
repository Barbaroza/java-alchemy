package com.pmb.code.datastructure.tree;

import com.pmb.code.model.TreeNode;

import java.util.LinkedList;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 说明:
 * <p>
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 * @author lvrui
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

    private final TreeNode empty = new TreeNode(-1);



    public boolean isSymmetric2(TreeNode root) {
        return bfs(root);
    }


    private boolean bfs(TreeNode root){
        if(root == null){
            return true;
        }
        LinkedList<TreeNode> deque = new LinkedList();

        deque.addFirst(root);

        while(!deque.isEmpty()){
            TreeNode[] arr = new TreeNode[deque.size()];
            for(int i =0 ;i<arr.length;i++){
                arr[i] = deque.removeFirst();
                if(arr[i]!=empty){
                    deque.addLast(arr[i].left !=null ? arr[i].left : empty);
                    deque.addLast(arr[i].right !=null ? arr[i].right : empty);
                }
            }
            if(!isMirrorLayer(arr)){
                return false;
            }
        }

        return true;
    }


    private boolean isMirrorLayer(TreeNode[] arr){
        if(arr == null){
            return true;
        }
        for(int i=0, j =arr.length -1 ;i<=j;i++,j--){
            if(arr[i]!=arr[j] && arr[i].val!=arr[j].val){
                return false;
            }
        }

        return true;



    }
}
