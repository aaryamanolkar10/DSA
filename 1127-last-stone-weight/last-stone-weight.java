class Solution {
    PriorityQueue<Integer> pq;

    public int lastStoneWeight(int[] stones) {
        //initialize pq
        pq = new PriorityQueue<>(Collections.reverseOrder());

        //push all elements of stones into pq
        for (int stone : stones) {
            pq.offer(stone);
        }

        //pop  2 greatest from pq and add to pq their diff
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (x != y) {
                pq.offer(x - y);
            }
        }

        //if pq empty return 0 or else top element of pq
        return pq.isEmpty() ? 0 : pq.poll();
    }
}