package com.pmb.code.datastructure.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvrui
 */
public class CopyRandomList {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }


    public Node copyRandomList(Node head) {
        Map<Node, Node> tempMap = new HashMap<>();
        Node currentNode = head;
        while (currentNode != null) {
            tempMap.put(currentNode, new Node(currentNode.val, null, null));
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
}
