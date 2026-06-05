class Solution {

    private String s;
    private long[][][][] memoCnt;
    private long[][][][] memoSum;
    private boolean[][][][] seen;

    private long[] dfs(int pos, int tight, int started,
                       int prev1, int prev2) {

        if (pos == s.length()) {
            return new long[]{1, 0};
        }

        if (seen[pos][tight][prev1 + 1][prev2 + 1] && started == 1) {
            return new long[]{
                memoCnt[pos][tight][prev1 + 1][prev2 + 1],
                memoSum[pos][tight][prev1 + 1][prev2 + 1]
            };
        }

        long count = 0;
        long sum = 0;

        int limit = tight == 1 ? s.charAt(pos) - '0' : 9;

        for (int d = 0; d <= limit; d++) {

            int ntight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {

                long[] nxt = dfs(pos + 1, ntight, 0, -1, -1);

                count += nxt[0];
                sum += nxt[1];

            } else {

                long add = 0;

                if (prev2 != -1) {

                    if ((prev1 > prev2 && prev1 > d) ||
                        (prev1 < prev2 && prev1 < d)) {
                        add = 1;
                    }
                }

                long[] nxt = dfs(pos + 1, ntight, 1, d, prev1);

                count += nxt[0];
                sum += nxt[1] + add * nxt[0];
            }
        }

        if (started == 1) {
            seen[pos][tight][prev1 + 1][prev2 + 1] = true;
            memoCnt[pos][tight][prev1 + 1][prev2 + 1] = count;
            memoSum[pos][tight][prev1 + 1][prev2 + 1] = sum;
        }

        return new long[]{count, sum};
    }

    private long solve(long x) {

        if (x < 0) return 0;

        s = String.valueOf(x);

        int n = s.length();

        memoCnt = new long[n + 1][2][11][11];
        memoSum = new long[n + 1][2][11][11];
        seen = new boolean[n + 1][2][11][11];

        return dfs(0, 1, 0, -1, -1)[1];
    }

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }
}