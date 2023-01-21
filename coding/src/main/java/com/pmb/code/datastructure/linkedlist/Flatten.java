package com.pmb.code.datastructure.linkedlist;

/**
 * 您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * <p>
 * 扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入:
 * 1---2---3---4---5---6--NULL
 * |
 * 7---8---9---10--NULL
 * |
 * 11--12--NULL
 * <p>
 * 输出:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 *
 * @author lvrui
 */
public class Flatten {

    public Node flatten(Node head) {
        Node current = head;
        Node res = current;
        while (current != null) {
            if (current.child != null) {
                insert(current);
            }
            current = current.next;
        }
        return res;
    }

    public void insert(Node current) {
        Node child = current.child;
        Node next = current.next;
        child.prev = current;
        current.next = child;

        Node childLast = child;
        while (childLast != null) {
            childLast = child.next;
            childLast = childLast.next;
        }
        childLast.next = next;
        next.prev = childLast;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }
}
