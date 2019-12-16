package com.pmb.code.datastructure.linkedlist;

import com.pmb.code.model.ListNode;

/**
 * 86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lvrui
 */
public class PartitionLink {
    public ListNode partition(ListNode head, int x) {
        ListNode res = null;
        if (head == null) {
            return res;
        }
        ListNode f = head;
        ListNode pref = null;
        int fcount = 0;
        ListNode s = head;
        ListNode pres = null;
        int scount = 0;
        while (true) {
            while (f != null) {
                if (f.val >= x) {
                    break;
                }
                fcount++;
                pref = f;
                f = f.next;
            }
            while (s != null) {

                if (s.val < x) {
                    if (res == null) {
                        res = s;
                    }
                    if (scount > fcount) {
                        swap(pref, pres, f, s);
                        ListNode temp = s;
                        s = f;
                        f = temp;

                        break;
                    }
                }

                scount++;
                pres = s;
                s = s.next;
            }

            if (s == null) {
                break;
            }
        }
        return res;
    }

    /**
     * [1,4,3,2,5,2]
     * [1,4,5,2,2,3]
     * 预期结果
     * [1,2,2,4,3,5]
     *
     * @param pref
     * @param pres
     * @param f
     * @param s
     */
    private void swap(ListNode pref, ListNode pres, ListNode f, ListNode s) {
        if (pref != null) {
            pref.next = s;
        }
        ListNode snext = s.next;
        s.next = f.next;
        if (pres != null) {
            pres.next = f;
        }
        f.next = snext;
    }

    /**
     * [1,4,3,2,5,2]
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(4);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(2);
//        listNode.next.next.next.next = new ListNode(5);
//        listNode.next.next.next.next.next = new ListNode(2);
        PartitionLink partitionLink = new PartitionLink();
        partitionLink.partition2(listNode, 0);
    }

    public ListNode partition2(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode beforeTemp = before;
        ListNode after = new ListNode(0);
        ListNode afterTemp = after;
        ListNode headtemp = head;
        while (headtemp != null) {
            if (headtemp.val >= x) {
                afterTemp.next = headtemp;
                afterTemp = headtemp;
            } else {
                beforeTemp.next = headtemp;
                beforeTemp = headtemp;
            }
            headtemp = headtemp.next;
        }
        afterTemp.next = null;
        beforeTemp.next = after.next;
        ListNode next = before.next;
        return next;
    }

}
