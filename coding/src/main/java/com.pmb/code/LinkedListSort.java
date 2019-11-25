package com.pmb.code;

/**
 * @author lvrui
 */
public class LinkedListSort {
    public static class LinkedNode<T extends Comparable> {
        public T val;
        public LinkedNode next;

        public LinkedNode(LinkedNode next, T t) {
            this.next = next;
            this.val = t;
        }
    }

    public void quickSort(LinkedNode root, LinkedNode end) {
        if (root != end) {
            LinkedNode node = partition(root, end);
            quickSort(root, node);
            quickSort(node.next, end);
        }
    }

    private LinkedNode partition(LinkedNode root, LinkedNode end) {
        LinkedNode partition = root;
        LinkedNode next = root.next;
        while (next != end) {
            if (partition.val.compareTo(next.val) > 0) {
                Comparable temp = next.val;
                next.val = partition.val;
                partition.val = temp;
                partition = next;
            }
            next = next.next;
        }
        return partition;
    }

    public static void main(String[] args) {
        LinkedNode<Integer> a = new LinkedNode(new LinkedNode<Integer>(new LinkedNode<Integer>(new LinkedNode<Integer>(null, 19), 12), 124), 5);
        LinkedListSort linkedListSort = new LinkedListSort();
        linkedListSort.quickSort(a, null);
        a = null;
    }

}
