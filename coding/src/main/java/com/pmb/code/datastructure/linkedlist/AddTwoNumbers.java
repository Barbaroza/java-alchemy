package com.pmb.code.datastructure.linkedlist;

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

    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode plusList1 = l1;
        ListNode plusList2 = l2;
        int remainder = 0;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (plusList1 != null || plusList2 != null || remainder != 0) {
            int current = 0;
            if (plusList1 != null) {
                current += plusList1.val;
                plusList1 = plusList1.next;
            }
            if (plusList2 != null) {
                current += plusList2.val;
                plusList2 = plusList2.next;
            }
            current += remainder;
            remainder = current / 10;
            current = current % 10;

            temp.next = new ListNode(current);
            temp = temp.next;
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
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res = AddTwoNumbers.addTwoNumbers3(l1, l2);
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

    public ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
        ListNode l1R = reverse(l1);
        ListNode l2R = reverse(l2);
        ListNode ans = new ListNode(-1);
        int rem = 0;

        ListNode l1RH = l1R;
        ListNode l2RH = l2R;
        ListNode ansH = ans;
        while(l1RH!=null || l2RH!=null||rem>0){
            int sum = rem;
            if(l2RH!=null){
                sum+=l2RH.val;
                l2RH = l2RH.next;
            }
            if(l1RH!=null){
                sum+=l1RH.val;
                l1RH=l1RH.next;
            }
            rem = sum>=10 ? 1:0;
            ansH.next = new ListNode(sum%10);
            ansH = ansH.next;
        }

        return reverse(ans.next);


    }

    private ListNode reverse(ListNode node){
        ListNode pre = null;
        ListNode cur = node;
        while(cur!=null){
            ListNode  t =  cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }


        return pre;


    }
}
