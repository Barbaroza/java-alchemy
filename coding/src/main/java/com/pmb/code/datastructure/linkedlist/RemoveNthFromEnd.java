package com.pmb.code.datastructure.linkedlist;

import com.pmb.code.model.ListNode;

/**
 * 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 *
 * @author lvrui
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while (fast != null) {
            if (count - n > 0) {
                slow = slow.next;
            }
            fast = fast.next;
            count++;
        }
        if (n == count) {
            return head.next;
        }
        slow.next = slow.next == null ? null : slow.next.next;
        return head;
    }


    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        int temp = n;
        while (fast != null && temp > 0) {
            fast = fast.next;
            temp--;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast != null) {
            if (fast.next == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next != null ? slow.next.next : null;

        return head;

    }


    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
        removeNthFromEnd.removeNthFromEnd2(listNode, 1);
    }

}

