package com.pmb.code.datastructure.linkedlist;

import com.pmb.code.model.ListNode;

/**
 * https://leetcode.cn/problems/LGjMqU/
 *
 * @author lvrui
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode q = head;
        ListNode s = head;
        while (q != null && q.next != null) {
            s = s.next;
            q = q.next.next;
        }
        ListNode mid = s.next;
        s.next = null;
        ListNode post = reverse(mid);
        ListNode cur = head;
        while (post != null) {
            ListNode t = cur.next;
            ListNode t2 = post.next;
            cur.next = post;
            post.next = t;
            cur = t;
            post = t2;
        }


    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;

        while (head != null) {
            ListNode t = head.next;
            head.next = pre;
            pre = head;
            head = t;
        }
        return pre;
    }
}
