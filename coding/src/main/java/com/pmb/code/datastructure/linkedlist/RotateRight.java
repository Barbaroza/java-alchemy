package com.pmb.code.datastructure.linkedlist;

import com.pmb.code.model.ListNode;

/**
 * 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * @author lvrui
 * @star
 */
public class RotateRight {
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            // base cases
            if (head == null) return null;
            if (head.next == null) return head;

            // close the linked list into the ring
            ListNode old_tail = head;
            int n;
            for (n = 1; old_tail.next != null; n++)
                old_tail = old_tail.next;
            old_tail.next = head;

            // find new tail : (n - k % n - 1)th node
            // and new head : (n - k % n)th node
            ListNode new_tail = head;
            for (int i = 0; i < n - k % n - 1; i++)
                new_tail = new_tail.next;
            ListNode new_head = new_tail.next;

            // break the ring
            new_tail.next = null;

            return new_head;
        }
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if(head == null || head.next == null || k<0)
        {
            return head;
        }
        ListNode pre = null,current = head;
        int size = 0;
        while(current!=null)
        {
            pre = current;
            current = current.next;
            size++;
        }

        ListNode last = pre;
        last.next = head;

        int offset =size -k% size;
        ListNode mid = null;
        pre = null;
        current = head;
        while(offset>0)
        {
            offset--;
            pre = current;
            current = current.next;
        }

        pre.next = null;
        return current;
    }
    public static void main(String[] args) {
        RotateRight rotate = new RotateRight();
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);

        ListNode listNode = new ListNode(1);

    }
}
