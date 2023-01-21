package com.pmb.code.datastructure.linkedlist;

/**
 * @author lvrui
 */
public class MyLinkedList {
    private Node head;
    private Node tail;
    int size = 0;

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < size) {
            Node temp = head;
            while (index > 0) {
                temp = temp.next;
                index--;
            }
            return temp.val;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size - 1, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        Node node = new Node(val);

        if (index < size || index == 0) {
            if (head == null) {
                head = node;
                tail = node;
            } else {
                Node temp = head;
                while (index > 1) {
                    temp = temp.next;
                    index--;
                }
                Node next = temp.next;
                node.next = next;
                if (index == 0) {
                    head = node;
                } else {
                    temp.next = node;
                }
                if (index == size - 1) {
                    tail = node;
                }
            }


            size++;

        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < size) {
            if (index == 0) {
                head = head.next;
                if (head == null) {
                    tail = null;
                }
            } else {
                Node temp = head;
                while (index > 1) {
                    temp = temp.next;
                    index--;
                }
                if (temp.next != null) {
                    temp.next = temp.next.next;
                    if (temp.next == null) {
                        tail = temp;
                    }
                }
            }

            size--;
        }
    }


    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3, 0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        myLinkedList.get(4);
        myLinkedList.addAtHead(4);
        myLinkedList.addAtIndex(5, 0);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtHead(4);
        myLinkedList.addAtIndex(5, 0);
        myLinkedList.addAtHead(6);

        myLinkedList.get(1);
        myLinkedList.get(1);

    }
}
