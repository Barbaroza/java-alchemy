package com.pmb.code.datastructure.linkedlist;

import com.pmb.code.model.Node;

/**
 * https://leetcode.cn/problems/4ueAj6/solution/jian-zhi-offer-ii-029-pai-xu-de-xun-huan-denk/
 *
 * @author lvrui
 */
public class Insert {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node insert = new Node(insertVal);

        if (head.next == head) {
            head.next = insert;
            insert.next = head;
            return head;
        }
        Node next = head.next;
        Node cur = head;
        while (next != head) {
            if (cur.val <= insertVal && next.val > insertVal) {
                break;
            }
            if (cur.next.val < cur.val && insertVal >= cur.val) {
                break;
            }
            if (cur.next.val < cur.val &&  cur.next.val>=insertVal) {
                break;
            }
            cur = cur.next;
            next = cur.next;
        }
        cur.next = insert;
        insert.next = next;

        return head;

    }


    public Node insert2(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        if (head.next == head) {
            head.next = node;
            node.next = head;
            return head;
        }
        Node curr = head, next = head.next;
        while (next != head) {
            if (insertVal >= curr.val && insertVal <= next.val) {
                break;
            }
            if (curr.val > next.val) {
                if (insertVal > curr.val || insertVal < next.val) {
                    break;
                }
            }
            curr = curr.next;
            next = next.next;
        }
        curr.next = node;
        node.next = next;
        return head;
    }


}
