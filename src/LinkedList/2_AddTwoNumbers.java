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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(l1 != null || l2 != null || carry != 0){
            int sum = carry + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            carry = sum / 10;
            int temp = sum % 10;

            ListNode node = new ListNode(temp);
            curr.next = node;
            curr = curr.next;
            l1 = (l1 != null ? l1.next : null);
            l2 = (l2 != null ? l2.next : null);
        }
        return dummy.next;
    }
}