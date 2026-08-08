class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slowNode = head, fastNode = head;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode)
                return true;
        }
        return false;
    }
}
