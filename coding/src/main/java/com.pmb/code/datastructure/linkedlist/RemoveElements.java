package com.pmb.code.datastructure.linkedlist;

import com.pmb.code.model.ListNode;

/**
 * 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @author lvrui
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode current = head;
        ListNode preNode = null;
        while (current != null) {
            if (current.val != val) {
                preNode = current;
            } else {
                if (preNode != null) {
                    preNode.next = current.next;
                } else {
                    head = current.next;
                }
            }
            current = current.next;
        }

        return head;
    }
}
