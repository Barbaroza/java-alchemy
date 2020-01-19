package com.pmb.code.datastructure.linkedlist;

import com.pmb.code.model.ListNode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lvrui
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode vNode = new ListNode(0);
        vNode.next = head;
        ListNode preNode = vNode;
        ListNode currentNode = head;
        int size = 0;
        while (currentNode != null) {
            size++;
            if (size == m) {
                ListNode start = currentNode;
                ListNode startPre = preNode;
                while (size <= n) {
                    ListNode next = currentNode.next;

                    size++;
                }

                break;
            }
            preNode = currentNode;
            currentNode = currentNode.next;
        }

        return vNode.next;
    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        int start = m, end = n;
        ListNode pre = null, current = head;
        while (start > 1) {
            pre = current;
            current = current.next;
            start--;
            end--;
        }
        ListNode middlePre = pre;
        ListNode middleNext = current;
        while (end > 0) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
            end--;
        }
        if (middlePre != null) {
            middlePre.next = pre;
        } else {
            head = pre;
        }
        middleNext.next = current;
        return head;
    }
}
