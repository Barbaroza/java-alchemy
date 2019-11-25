package com.pmb.code2.test;

import java.util.Objects;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author Administrator
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode result = new ListNode(0);
        ListNode resNext = result;
        ListNode tempResult = null;
        while (!Objects.isNull(temp1) || !Objects.isNull(temp2)) {

            tempResult = sum(temp1, tempResult);
            temp1 = temp1 == null ? null : temp1.next;
            tempResult = sum(temp2, tempResult);
            temp2 = temp2 == null ? null : temp2.next;
            System.out.println(tempResult.val);
            resNext.next = tempResult;
            resNext = resNext.next;
            tempResult = tempResult.next;
        }

        return result.next;
    }

    public static ListNode sum(ListNode temp, ListNode result) {

        if (Objects.isNull(temp)) {
            return result;
        }
        if (result == null) {
            result = new ListNode(0);
        }
        int index1 = temp.val;
        int index2 = result.val;
        int sum = index1 + index2;
        if (sum >= 10) {
            result.val = sum % 10;
            result.next = sum(new ListNode(1), result.next);
        } else {
            result.val = sum;
        }
        return result;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(1);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);

        ListNode res = AddTwoNumbers.addTwoNumbers2(l1, l2);
        int dfsdf = res.next.val;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode temp = res;
        if (l1 == null || l2 == null) {
            return res;
        }
        ListNode list1 = l1;
        ListNode list2 = l2;
        int next = 0;
        while (list1 != null || list2 != null || next != 0) {
            temp.next = new ListNode(0);
            temp = temp.next;
            int val1 = 0, val2 = 0;
            if (list1 != null) {
                val1 = list1.val;
                list1 = list1.next;
            }
            if (list2 != null) {
                val2 = list2.val;
                list2 = list2.next;
            }
            int current = val1 + val2 + next;
            next = 0;
            if (current >= 10) {
                next = current / 10;
                current = current % 10;
            }
            if (temp != null) {
                temp.val = current;
            } else {
                temp = new ListNode(current);
            }
        }
        return res.next;
    }
}
