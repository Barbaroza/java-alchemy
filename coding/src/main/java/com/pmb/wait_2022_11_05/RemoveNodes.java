package com.pmb.wait_2022_11_05;

import com.pmb.code.model.ListNode;

import java.util.LinkedList;

/**
 * @author lvrui
 */
public class RemoveNodes {
    public ListNode removeNodes(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();

        while (head != null) {
            while (!stack.isEmpty() && stack.getLast().val < head.val) {
                stack.removeLast();
            }
            stack.addLast(head);
            head = head.next;
        }
        ListNode newHead = null;

        ListNode pre = null;
        while (!stack.isEmpty()) {
            ListNode listNode = stack.removeFirst();
            if (newHead == null) {
                newHead = listNode;
            }
            if (pre != null) {
                pre.next = listNode;
            }
            pre = listNode;
        }
        pre.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(13);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(8);
        RemoveNodes removeNodes = new RemoveNodes();
        removeNodes.removeNodes(listNode);
    }
}
