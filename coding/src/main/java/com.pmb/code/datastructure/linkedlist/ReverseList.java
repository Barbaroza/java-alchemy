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
    public ListNode reverseList3(ListNode head) {
        if(head == null)
        {
            return head;
        }
        ListNode pre = null;
        ListNode current = head;
        while (current!=null)
        {
           ListNode next =  current.next;
           current.next = pre;
           pre = current;
            current = next;
        }
        return pre;
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
