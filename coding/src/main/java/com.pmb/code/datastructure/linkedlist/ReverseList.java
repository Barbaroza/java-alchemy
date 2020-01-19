package com.pmb.code.datastructure.linkedlist;


public class ReverseList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        ListNode preNode = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = preNode;
            preNode = current;
            current = next;
        }
        return preNode;
    }

    ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode last = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
