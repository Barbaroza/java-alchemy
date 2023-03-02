package com.pmb.code.datastructure.linkedlist;

import com.pmb.code.model.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 *
 * @author lvrui
 */
public class CopyRandomList {


    public Node copyRandomList(Node head) {
        Map<Node, Node> tempMap = new HashMap<>();
        Node currentNode = head;
        while (currentNode != null) {
            tempMap.put(currentNode, new Node(currentNode.val));
            currentNode = currentNode.next;
        }
        currentNode = head;
        while (currentNode != null) {
            Node copyNode = tempMap.get(currentNode);
            copyNode.next = tempMap.get(currentNode.next);
            copyNode.random = tempMap.get(currentNode.random);
            currentNode = currentNode.next;
        }
        return tempMap.get(head);
    }
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }


        Node old = head;
        while (old != null) {
            Node oNext = old.next;
            old.next = new Node(old.val);
            old.next.next = oNext;
            old = oNext;
        }
        Node ans = head.next;

        old = head;

        while (old != null) {
            old.next.random = old.random!=null ?  old.random.next :null;
            old = old.next.next;
        }

        old = head;

        while (old != null) {
            Node oNext = old.next.next;
            old.next.next = oNext != null ? oNext.next : null;
            old.next = oNext;
            old = oNext;
        }
        return ans;
    }
}
