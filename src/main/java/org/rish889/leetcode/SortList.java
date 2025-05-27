package org.rish889.leetcode;

public class SortList {
    public static void main(String args[]) {
        //4,2,1,3
        ListNode a3 = new ListNode(3);
        ListNode a1 = new ListNode(1, a3);
        ListNode a2 = new ListNode(2, a1);
        ListNode a4 = new ListNode(4, a2);

        ListNode result = new Solution().sortList(a4);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
            System.out.println(", ");
        }
        System.out.println();
    }
}

class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return null;
        }
        ListNode middleNode = getMiddleNode(head);

        ListNode firstHalf = head;
        ListNode secondHalf = middleNode.next;
        middleNode.next = null;

        ListNode firstSortedHalf = mergeSort(firstHalf);
        ListNode secondSortedHalf = mergeSort(secondHalf);

        ListNode sortedResult = merge(firstSortedHalf, secondSortedHalf);
        return sortedResult;
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while (p1 != null && p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    private ListNode merge(ListNode firstSortedHalf, ListNode secondSortedHalf) {
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}