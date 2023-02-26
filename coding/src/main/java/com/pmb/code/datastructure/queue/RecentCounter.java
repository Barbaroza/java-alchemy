package com.pmb.code.datastructure.queue;

import java.util.LinkedList;

/**
 * @author lvrui
 */
public class RecentCounter {
    LinkedList<Integer> deque = null;

    public RecentCounter() {
        deque = new LinkedList();

    }

    public int ping(int t) {
        while (!deque.isEmpty() && deque.getFirst() + 3000 < t) {
            deque.removeFirst();
        }
        deque.addLast(t);

        return deque.size();
    }
}
