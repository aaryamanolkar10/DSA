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
    public ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode prev=null,next=null;
        ListNode curr=A;

        while(B>1){
            prev=curr;
            curr=curr.next;
            B--;
            C--;
        }
        ListNode connection=prev;
        ListNode tail=curr;
        while(C>0){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            C--;
        }
        if(connection!=null){
            connection.next=prev;
        }
        else{
            A=prev;
        }
        tail.next=curr;
        return A;

    }
}