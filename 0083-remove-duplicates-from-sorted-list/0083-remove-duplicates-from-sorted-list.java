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
        if (head==null) return null;
        ListNode temp=head;
        while (temp.next!=null){
            if (temp.val==temp.next.val){
                ListNode p=temp.next;
                if (temp.next.next==null) temp.next=null;
                else {
                    temp.next=temp.next.next;
                    p.next=null;
                }
            }
            else {
                 temp=temp.next;
            }
           
        }

        return head;
    }
}