package com.pmb.code.multipointers;

import com.pmb.code.model.ListNode;

/**
 * @author lvrui
 */
public class GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        int cnt = k;
        ListNode cur = head;
        while (cnt > 0 && cur != null) {
            cnt--;
            cur = cur.next;
        }
        ListNode ans = head;
        while (cur != null) {
            ans = ans.next;
            cur = cur.next;
        }

        return ans;
    }
}