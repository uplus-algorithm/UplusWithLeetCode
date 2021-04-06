/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {


    public ListNode middleNode(ListNode head) {
        ListNode middle = new ListNode();
        boolean flag = true;
        ListNode cnt = new ListNode(head.val, head.next);
        Queue<ListNode> q = new LinkedList<>();
        q.add(head);
        while(true) {
            cnt = cnt.next;
            if(flag == true) {
                middle = q.poll();
                flag = false;
            }else {
                flag = true;
            }
            if(cnt == null) {
                if(flag) {
                    middle = q.poll();
                }

                break;
            }
            else {
                q.add(cnt);
            }
        }
        return middle;
    }
}