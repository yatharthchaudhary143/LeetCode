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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode temp=head;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int count=0;
        int last=0;
        int first=0;
        
        boolean crit=false;;

        while(temp.next.next!=null){
            count++;
            if (temp.next.val>temp.val && temp.next.val>temp.next.next.val){
                crit=true;
            }
            else if (temp.next.val<temp.val && temp.next.val<temp.next.next.val){
                crit=true;
            }

            if (crit){
                if (first==0){
                    first=count;
                }
                if (last!=0){
                    min=Math.min(min, count-last);
                }
                crit=false;
                last=count;
            }

            temp=temp.next;
        }

        if (first==last){
            return new int[]{-1, -1};
        }

        max=last-first;

        return new int[]{min, max};
    }
}