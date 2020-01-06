package com.pmb.code.datastructure.linkedlist;

import com.pmb.code.model.ListNode;

/**
 * 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * @author lvrui
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode node = new ListNode(0);
        if (lists == null || lists.length == 0) {
            return node.next;
        }
        append(lists, node);
        return node.next;
    }

    private void append(ListNode[] lists, ListNode node) {
        ListNode min = null;
        Integer i = -1;
        for (int index = 0; index < lists.length; index++) {
            ListNode current = lists[index];
            if (current != null) {
                if (min == null) {
                    min = current;
                    i = index;
                } else if (min.val > current.val) {
                    min = current;
                    i = index;
                }
            }
        }

        if (min != null) {
            node.next = min;
            lists[i] = min.next;
            append(lists, node.next);
        }
    }

    public static void main(String[] args) {

    }
}
