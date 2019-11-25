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
        ListNode pre = null;
        ListNode next = null;
        ListNode currnet = head;
        while (currnet != null) {
            next = currnet.next;
            currnet.next = pre;
            pre = currnet;
            currnet = next;

        }
        return pre;
    }
}
