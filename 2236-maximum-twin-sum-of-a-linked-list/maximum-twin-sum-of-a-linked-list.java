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
    public int pairSum(ListNode head) {
        ListNode current = head;
        Stack<Integer> stack = new Stack<>();

        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }
        current = head;
        int maxSum = 0;
        int count = 1;
        int size = stack.size();
        while (count <= size / 2) {
            maxSum = Math.max(maxSum, current.val + stack.peek());
            current = current.next;
            stack.pop();
            count++;
        }
        return maxSum;
    }
}