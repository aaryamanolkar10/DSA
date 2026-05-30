import java.util.*;

class Solution {

    class FenwickTree {
        int[] bit;

        FenwickTree(int n) {
            bit = new int[n + 1];
        }

        void update(int index, int value) {
            while (index < bit.length) {
                bit[index] = Math.max(bit[index], value);
                index += index & -index;
            }
        }

        int query(int index) {
            int res = 0;

            while (index > 0) {
                res = Math.max(res, bit[index]);
                index -= index & -index;
            }

            return res;
        }
    }

    public List<Boolean> getResults(int[][] queries) {
        int limit = Math.min(50000, queries.length * 3);

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        obstacles.add(limit);

        for (int[] q : queries) {
            if (q[0] == 1) {
                obstacles.add(q[1]);
            }
        }

        FenwickTree bit = new FenwickTree(limit + 1);

        Integer prev = null;
        for (int pos : obstacles) {
            if (prev != null) {
                bit.update(pos, pos - prev);
            }
            prev = pos;
        }

        List<Boolean> ans = new ArrayList<>();

        for (int i = queries.length - 1; i >= 0; i--) {
            int[] q = queries[i];

            if (q[0] == 1) {
                int x = q[1];

                Integer left = obstacles.lower(x);
                Integer right = obstacles.higher(x);

                if (right != null) {
                    bit.update(right, right - left);
                }

                obstacles.remove(x);

            } else {
                int x = q[1];
                int sz = q[2];

                int prevObstacle = obstacles.floor(x);

                boolean possible = bit.query(prevObstacle) >= sz ||
                        x - prevObstacle >= sz;

                ans.add(possible);
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}