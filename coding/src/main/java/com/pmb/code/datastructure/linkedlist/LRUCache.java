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
    Node headNode;
    Node tailNode;
    int size;
    int capacity;
    Map<Integer, Node> cacheMap;

    class Node {
        int key, value;
        Node preNode;
        Node nextNode;
    }

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cacheMap = new HashMap<>(capacity);
        headNode = new Node();
        tailNode = new Node();
        headNode.nextNode = tailNode;
        tailNode.preNode = headNode;
    }

    public int get(int key) {
        Node node = cacheMap.get(key);
        if (node != null) {
            removeNode(node);
            insertHead(node);
        }
        return node == null ? -1 : node.value;
    }

    private void insertHead(Node node) {
        Node nextNode = this.headNode.nextNode;
        this.headNode.nextNode = node;
        nextNode.preNode = node;
        node.nextNode = nextNode;
        node.preNode = headNode;
        this.size++;
    }

    private Node removeNode(Node node) {
        node.preNode.nextNode = node.nextNode;
        node.nextNode.preNode = node.preNode;
        this.size--;
        return node;
    }

    public void put(int key, int value) {
        Node node = cacheMap.get(key);
        if (node != null) {
            removeNode(node);
            cacheMap.remove(key);
        } else {
            if (size == capacity) {
                cacheMap.remove(removeTail().key);
            }
        }
        Node insert = new Node();
        insert.key = key;
        insert.value = value;
        insertHead(insert);
        this.cacheMap.put(key, insert);

    }

    private Node removeTail() {
        Node remove = this.tailNode.preNode;
        this.tailNode.preNode = this.tailNode.preNode.preNode;
        this.tailNode.preNode.nextNode = this.tailNode;
        this.size--;
        return remove;
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
        l2.put(3, 3);
        l2.get(1);
        l2.get(2);
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
