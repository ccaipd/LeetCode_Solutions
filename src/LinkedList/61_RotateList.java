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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;

        int size = 0;
        ListNode curr = head;
        while(curr != null) {
            size++;
            curr = curr.next;
        }

        ListNode prev = null;
        curr = head;
        k = k % size;
        while(k > 0) {
            while(curr.next != null) {
                prev = curr;
                curr = curr.next;
            }

            curr.next = head;
            prev.next = null;
            head = curr;
            k--;
        }

        return head;
    }
}