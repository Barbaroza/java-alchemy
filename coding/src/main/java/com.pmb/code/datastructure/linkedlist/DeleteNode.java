package com.pmb.code.datastructure.linkedlist;

/**
 * @author lvrui
 */
public class DeleteNode {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }

        ListNode next = node.next;
        node.next = next.next;
        node.val = next.val;
    }
}
