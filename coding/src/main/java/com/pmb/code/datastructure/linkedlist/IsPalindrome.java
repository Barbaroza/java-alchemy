package com.pmb.code.datastructure.linkedlist;


import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        List<ListNode> temp = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            temp.add(current);
            current = current.next;
        }
        for (int i = 0, j = temp.size() - 1; i < j; i++, j--) {
            if (temp.get(i).val != temp.get(j).val) {
                return false;
            }
        }
        return true;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
