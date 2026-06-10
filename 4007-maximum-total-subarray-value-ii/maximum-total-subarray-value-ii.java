import java.util.*;

class Solution {

    int[] lg;
    int[][] mx;
    int[][] mn;

    private long value(int l, int r) {
        int len = r - l + 1;
        int k = lg[len];

        int maxVal = Math.max(
                mx[l][k],
                mx[r - (1 << k) + 1][k]);

        int minVal = Math.min(
                mn[l][k],
                mn[r - (1 << k) + 1][k]);

        return (long) maxVal - minVal;
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        lg = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            lg[i] = lg[i / 2] + 1;
        }

        int m = lg[n] + 1;

        mx = new int[n][m];
        mn = new int[n][m];

        for (int i = 0; i < n; i++) {
            mx[i][0] = nums[i];
            mn[i][0] = nums[i];
        }

        for (int j = 1; j < m; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                mx[i][j] = Math.max(
                        mx[i][j - 1],
                        mx[i + (1 << (j - 1))][j - 1]);

                mn[i][j] = Math.min(
                        mn[i][j - 1],
                        mn[i + (1 << (j - 1))][j - 1]);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(b.val, a.val));

        for (int l = 0; l < n; l++) {
            pq.offer(
                    new Node(
                            l,
                            n - 1,
                            value(l, n - 1)));
        }

        long ans = 0;

        while (k-- > 0) {
            Node cur = pq.poll();

            ans += cur.val;

            if (cur.r > cur.l) {
                pq.offer(
                        new Node(
                                cur.l,
                                cur.r - 1,
                                value(cur.l, cur.r - 1)));
            }
        }

        return ans;
    }

    static class Node {
        int l;
        int r;
        long val;

        Node(int l, int r, long val) {
            this.l = l;
            this.r = r;
            this.val = val;
        }
    }
}