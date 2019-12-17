package com.pmb.code.datastructure.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lvrui
 */
public class LRUCache {
    class Node {
        int key;
        int value;
        Node preNode;
        Node nextNode;

        Node() {

        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private Map<Integer, Node> cacheMap = null;
    private int capacity;
    private int size;

    private Node head;
    private Node tail;

    public LRUCache(final int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.cacheMap = new HashMap<>(capacity);
        this.head = new Node();
        this.tail = new Node();
        this.head.nextNode = this.tail;
        this.tail.preNode = this.head;

    }

    private Node removeTail() {
        Node preNode = tail.preNode;
        this.tail.preNode = tail.preNode.preNode;
        this.tail.preNode.nextNode = this.tail;
        this.size--;
        return preNode;
    }

    private Node remove(Node node) {
        node.preNode.nextNode = node.nextNode;
        node.nextNode.preNode = node.preNode;
        this.size--;
        return node;
    }

    private void insertHead(Node node) {
        Node temp = this.head.nextNode;
        this.head.nextNode = node;
        node.preNode = this.head;
        node.nextNode = temp;
        temp.preNode = node;
        size++;
    }


    public int get(int key) {
        Node node = this.cacheMap.get(key);
        if (node != null) {
            this.remove(node);
            this.insertHead(node);
        }

        return node == null ? -1 : node.value;
    }

    public void put(int key, int value) {
        Node node = this.cacheMap.get(key);
        Node insert = new Node(key, value);
        if (node != null) {
            this.cacheMap.remove(this.remove(node).key);
        } else {
            if (this.size == this.capacity) {
                this.cacheMap.remove(removeTail().key);
            }
        }
        this.insertHead(insert);
        cacheMap.put(key, insert);
    }

    /**
     * ["LRUCache","put","put","get","put","get","put","get","get","get"]
     * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
     * <p>
     * <p>
     * ["LRUCache","put","put","get","put","get","put","get","get","get"]
     * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
     * <p>
     * <p>
     * ["LRUCache","put","put","get","put","get","put","get","get","get"]
     * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
     *
     * @param args
     */
    public static void main(String[] args) {

        LRUCache l2 = new LRUCache(2);
        l2.put(1, 1);
        l2.put(2, 2);
        l2.get(1);
        l2.put(3, 3);
        l2.get(2);
        l2.put(4, 4);
        l2.get(1);
        l2.get(3);
        l2.get(4);
        LRUCache l = new LRUCache(1);
        l.put(2, 2);
        l.get(2);
        l.put(3, 3);
        l.get(2);
        l.get(3);
        l.put(3, 3);
        l.get(2);
        l.put(4, 4);
        l.get(1);
        l.get(3);
        l.get(4);

    }
}
