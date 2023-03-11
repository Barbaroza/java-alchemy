package com.pmb.code.datastructure.linkedlist;

/**
 * https://leetcode.cn/problems/Qv1Da2/submissions/
 *
 * @author lvrui
 */
public class Flatten2 {
    public Node flatten(Node head) {
        f(head);
        return head;
    }

    private Node f(Node head) {
        if (head == null) {
            return null;
        }
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            if (cur.child == null) {
                pre = cur;
                cur = cur.next;
            } else {
                Node t = cur.next;
                cur.next = cur.child;
                cur.child.prev = cur;
                pre = f(cur.child);
                cur.child = null;

                pre.next = t;
                if (t != null) {
                    t.prev = pre;
                }
                cur = t;
            }

        }
        return pre;


    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    ;
}
