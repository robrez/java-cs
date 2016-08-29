package com.jcs.leetcode;

/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 *
 * For example,
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 *
 * Note: Given n will always be valid. Try to do this in one pass.
 *
 * @author rar1941
 */
public class Prob0019RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        Prob0019RemoveNthNodeFromEndOfList p = new Prob0019RemoveNthNodeFromEndOfList();
        ListNode result = p.removeNthFromEnd(all(1, 2, 3, 4, 5), 2);
        System.out.println("result:" + toString(result));

    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode all(int... items) {
        if (items == null || items.length == 0) {
            return null;
        }
        ListNode n = new ListNode(items[0]);
        ListNode temp = n;
        for (int i = 1; i < items.length; i++) {
            ListNode newNode = new ListNode(items[i]);
            temp.next = newNode;
            temp = newNode;
        }
        return n;
    }

    public static String toString(ListNode n) {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(n.val));
        n = n.next;
        while (n != null) {
            sb.append(", ");
            sb.append(Integer.toString(n.val));
            n = n.next;
        }
        return sb.toString();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < n; i++) {
            second = second.next;
        }
        while (second.next != null) {
            second = second.next;
            first = first.next;
        }
        first.next = first.next.next;
        return head;
    }
}
