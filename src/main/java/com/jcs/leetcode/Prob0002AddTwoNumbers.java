package com.jcs.leetcode;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 *
 * @author rar1941
 */
public class Prob0002AddTwoNumbers {

    /**
     * Problem uses a singly-linked list
     *
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     *
     * Output: (7 -> 0 -> 8)
     */
    public static class ListNode {

        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }

        public ListNode add(int x) {
            if (next == null) {
                ListNode n = new ListNode(x);
                next = n;
                return n;
            } else {
                return next.add(x);
            }
        }

        public static ListNode all(int... items) {
            if (items == null || items.length == 0) {
                return null;
            }
            ListNode n = new ListNode(items[0]);
            ListNode temp = n;
            for (int i = 1; i < items.length; i++) {
                temp = temp.add(items[i]);
            }
            return n;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(val));
            ListNode n = next;
            while (n != null) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(Integer.toString(n.val));
                n = n.next;
            }
            return sb.toString();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ListNode l1 = ListNode.all(2, 4, 3);
        //ListNode l2 = ListNode.all(5, 6, 4);
        ListNode l1 = ListNode.all(9, 9);
        ListNode l2 = ListNode.all(1);
        Prob0002AddTwoNumbers p = new Prob0002AddTwoNumbers();
        ListNode result = p.addTwoNumbers(l1, l2);
        System.out.println(result.toString());
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode result = null;
        int v;
        int r;
        int carry = 0;
        ListNode prev = null;
        ListNode temp;
        while (head1 != null || head2 != null) {
            v = 0;
            if (head1 != null && head2 != null) {
                v = head1.val + head2.val;
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1 != null) {
                v = head1.val;
                head1 = head1.next;
            } else if (head2 != null) {
                v = head2.val;
                head2 = head2.next;
            }
            v += carry;
            carry = v / 10;
            v = v % 10;
            temp = new ListNode(v);
            if (prev == null) {
                prev = temp;
                result = temp;
            } else {
                prev.next = temp;
                prev = temp;
            }
        }
        if (carry > 0 && prev != null) {
            prev.next = new ListNode(carry);
        }
        return result;
    }
}
