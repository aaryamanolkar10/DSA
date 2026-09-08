class Solution {
    PriorityQueue<Integer> pq;

    public int findKthLargest(int[] nums, int k) {
        pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}