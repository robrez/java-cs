package com.jcs.leetcode;

/**
 *
 * @author rar1941
 */
public class Prob0328OddEvenLinkedList {
    
    public static void main(String[] args) {
        Prob0328OddEvenLinkedList p = new Prob0328OddEvenLinkedList();
        ListNode result = p.oddEvenList(all(1, 2, 3, 4, 5));
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

    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        ListNode odd = head;
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }

}
