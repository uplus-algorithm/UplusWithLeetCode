package main.java.LeetCode876;

public class Solution {
    public ListNode middleNode(ListNode head) {
        int size = 0;

        ListNode tmp = new ListNode(head.val, head);
        while (tmp.next != null) {
            size += 1;
            tmp = tmp.next;
        }

        for (int i = 0; i < size / 2; i++) {
            head = head.next;
        }

        return head;
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

    public static void main(String[] args) {
        System.out.println("hello world");
    }
}

