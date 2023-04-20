package com.pmb.code.datastructure.linkedlist;

import com.pmb.code.model.ListNode;

/**
 * https://leetcode.cn/problems/partition-list-lcci/submissions/
 *
 * @author lvrui
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode vNode = new ListNode(-1);
        vNode.next = head;
        ListNode pre = vNode;
        ListNode insert = null;
        ListNode cur = vNode.next;
        boolean flag = false;
        while (cur != null) {
            if (cur.val >= x) {
                insert = pre;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre = insert;
        cur = insert != null ? insert.next : null;
        while (cur != null) {
            if (cur.val < x) {
                ListNode t = cur;
                cur = cur.next;
                pre.next = cur;

                t.next = insert.next;
                insert.next = t;
                insert = t;
            } else {
                pre = cur;
                cur = cur.next;
            }

        }


        return vNode.next;
    }
}
