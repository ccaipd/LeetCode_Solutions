package LinkedList;

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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while(cur != null) {
            while(cur.next != null && cur.next.val == cur.val)
                cur = cur.next;
            // why use pre.next == cur not pre.next.val == cur.val?
            // To check whether cur has moved forward or not.
            // Make sure if current position's element is unique, then you can move forward, so you have to compare pointers. The value's comparison is only to find dups and discard them.
            if(pre.next == cur)
                pre = pre.next;
            else
                pre.next = cur.next;
            cur = cur.next;
        }

        return dummy.next;
    }
}