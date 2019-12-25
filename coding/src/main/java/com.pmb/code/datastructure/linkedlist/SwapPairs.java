package com.pmb.code.datastructure.linkedlist;

import com.pmb.code.model.ListNode;

/**
 * 24. 两两交换链表中的节点
 * <p>
 * <p>
 * <p>
 * <p>
 * 题目描述
 * 评论 (579)
 * 题解(237)
 * 提交记录
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @author lvrui
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode temp = head;
        ListNode res = head.next != null ? head.next : head;
        ListNode pre = null;
        while (temp != null) {
            if (temp.next != null) {
                ListNode nextnext = temp.next.next;
                temp.next.next = temp;
                if (pre != null) {
                    pre.next = temp.next;
                }
                temp.next = nextnext;
                pre = temp;
            }
            temp = temp.next;
        }

        return res;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs2(next.next);
        next.next = head;
        return next;
    }
}
