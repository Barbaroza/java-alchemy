package com.pmb.code.datastructure.linkedlist;

import com.pmb.code.model.ListNode;

/**
 * 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author lvrui
 */
public class mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        if (l1 == null && l2 == null) {
            return head.next;
        }
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode temp = head;
        while (true) {
            ListNode currentMin = null;
            if (temp1 != null && temp2 != null) {
                if (temp1.val > temp2.val) {
                    currentMin = temp2;
                    temp2 = temp2.next;
                } else {
                    currentMin = temp1;
                    temp1 = temp1.next;
                }

            }
            if (temp1 != null && currentMin == null) {
                currentMin = temp1;
                temp1 = temp1.next;
            }
            if (temp2 != null && currentMin == null) {
                currentMin = temp2;
                temp2 = temp2.next;
            }
            if (currentMin == null) {
                break;
            }
            temp.next = currentMin;
            temp = temp.next;
        }

        return head.next;
    }
}
