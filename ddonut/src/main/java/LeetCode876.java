

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class LeetCode876 {
    public ListNode middleNode(ListNode head) {
        ListNode p = head;
        ListNode p2 = head;
        while(true){
            if(p2.next != null && p2.next.next != null){
                p = p.next;
                p2 = p2.next.next;
            }else{
                return p;
            }
        }

    }
}