package com.pmb.code.datastructure.linkedlist;

/**
 * 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * @author lvrui
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode ji = head, ou = head.next, ouindex = ou;
        while (ji.next != null && ou.next != null) {
            ji.next = ji.next.next;
            ou.next = ou.next.next;
            ji = ji.next;
            ou = ou.next;
        }
        ji.next = ouindex;
        return head;
    }

    public ListNode oddEvenList2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode ji = head;
        ListNode ou = head.next;
        ListNode ouIndex = ou;
        while (ji.next != null && ou.next != null) {
            ListNode temp =
                    ji.next = ji.next.next;
            ji = ji.next;
            ou.next = ou.next.next;
            ou = ou.next;
        }
        ji.next = ouIndex;
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
