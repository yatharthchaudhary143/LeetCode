class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first=head;

        for (int i=1; i<k; i++) {
            first=first.next;
        }

        ListNode curr=first;
        ListNode second=head;

        while (curr.next!=null) {
            curr=curr.next;
            second=second.next;
        }

        int temp=first.val;
        first.val=second.val;
        second.val=temp;

        return head;
    }
}