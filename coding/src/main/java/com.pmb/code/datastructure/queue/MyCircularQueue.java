package com.pmb.code.datastructure.queue;

/**
 * @author lvrui
 */
public class MyCircularQueue {
    class Node{
        int val;
        Node next;
        Node(int val)
        {
            this.val = val;
        }
    }
    int capacity =0;
    int size =0;
    Node head;
    Node tail;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {

        capacity=k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(size<capacity)
        {
            Node newNode = new Node(value);
            if (this.size == 0) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;

            return true;
        }else{
            return false;
        }
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(size == 0)
        {
            return false;
        }
        this.head=head.next;
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(size>0)
        {
            return head.next.val;
        }else{
            return -1;
        }
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(size >0)
        {
            return tail.val;
        }else{
            return -1;
        }
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}
