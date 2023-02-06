package com.pmb.wait_2023_02_02;

import com.pmb.code.model.ListNode;

/**
 * @author lvrui
 */
public class LinkNodeSolution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode preMHead = null;
        ListNode mHead = null;
        ListNode nTail = null;

        int index = 1;
        int end = n;

        ListNode preNode = null;
        ListNode curNode = head;

        while (index <= end) {

            if (index > m) {

                ListNode temp = curNode.next;
                curNode.next = preNode;
                preNode = curNode;
                curNode = temp;

                if (end == index) {
                    nTail = curNode;
                    mHead.next = nTail;
                }
                index++;



            } else {

                if (m == index) {
                    preMHead = preNode;
                    mHead = curNode;
                }

                preNode = curNode;
                curNode = preNode.next;
                index++;
            }

        }

        if (preMHead != null) {

            preMHead.next = preNode;
        }


        return preMHead == null ? preNode : head;
        // write code here
    }
    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode vNode = new ListNode(1);
        vNode.next = head;
        // write code here
        int length = 1;
        ListNode temp = vNode.next;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        int index2Del = length-n;
        ListNode pre = null;
        ListNode cur = vNode;
        for(int i =0;i<=index2Del;i++){
            pre = cur;
            cur = cur.next;
        }

        pre.next = cur.next;


        return vNode.next;
    }



    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        ListNode vNode = new ListNode(9123);
        vNode.next = head;
        ListNode tempNode = vNode.next;
        ListNode cleanNode =vNode;
        while(tempNode!=null){
            boolean isUnique = true;

            while(tempNode.next!=null && tempNode.next.val == tempNode.val){
                tempNode = tempNode.next;
                isUnique = false;
            }

            if(isUnique){
                cleanNode =  tempNode;
            }
            cleanNode.next = tempNode.next;

            tempNode =  tempNode.next;
        }


        return vNode.next;


    }
    public static void main(String[] args) {
        LinkNodeSolution isBalanced = new LinkNodeSolution();
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(3);
        listNode1.next = listNode2;
        isBalanced.removeNthFromEnd(listNode1,  2);
    }
}
