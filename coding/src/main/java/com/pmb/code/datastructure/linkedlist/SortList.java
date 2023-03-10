package com.pmb.code.datastructure.linkedlist;

/**
 * @author lvrui
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        return merge(right, left);
    }

    private ListNode merge(ListNode r, ListNode l) {
        ListNode left = l;
        ListNode right = r;
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        ListNode res;
        if (l.val < r.val) {
            res = new ListNode(l.val);
            left = left.next;
        } else {
            res = new ListNode(r.val);
            right = right.next;
        }
        ListNode temp = res;
        while (right != null || left != null) {
            if (left == null) {
                temp.next = right;
                return res;
            } else if (right == null) {
                temp.next = left;
                return res;
            } else if (left.val < right.val) {
                temp.next = left;
                left = left.next;
                temp = temp.next;

            } else {
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }

        return res;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(4);
        SortList sortList = new SortList();
        head = sortList.sortList3(head);
        head = null;
    }

    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode doubleCurrent = head;
        while (doubleCurrent.next != null && doubleCurrent.next.next != null) {
            current = current.next;
            doubleCurrent = doubleCurrent.next.next;
        }
        ListNode leftList = sortList2(current.next);
        current.next = null;
        ListNode rightList = sortList2(head);
        return sort(leftList, rightList);
    }

    private ListNode sort(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        ListNode vNode = new ListNode(0);
        ListNode vTemp = vNode;
        while (right != null || left != null) {
            if (right == null) {
                vTemp.next = left;
                break;
            }
            if (left == null) {
                vTemp.next = right;
                break;
            }
            ListNode tempNode = null;
            if (left.val < right.val) {
                tempNode = left;
                left = left.next;
            } else {
                tempNode = right;
                right = right.next;
            }
            vTemp.next = tempNode;
            vTemp = vTemp.next;
            vTemp.next = null;
        }

        return vNode.next;
    }


    public ListNode sortList3(ListNode head) {

        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode q = head;
        ListNode s = head;
        while (q != null && q.next != null) {
            q = q.next.next;
            s = s.next;
        }
        ListNode right = mergeSort(s.next);
        s.next = null;
        ListNode left = mergeSort(head);
        ListNode vNode = new ListNode(0);
        ListNode pre = vNode;
        while (left != null || right != null) {
            ListNode next = null;
            if (right != null && left != null) {
                if (right.val < left.val) {
                    next = right;
                    right = right.next;
                } else {
                    next = left;
                    left = left.next;
                }
            } else if (right == null) {
                next = left;
                left = left.next;
            } else {
                next = right;
                right = right.next;
            }
            pre.next = next;
            pre = next;
        }


        return vNode.next;
    }


}
