class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int states = 2 * m;

        long[][] T = new long[states][states];

        for (int prev = 0; prev < m; prev++) {

            // down[prev] -> up[cur]
            for (int cur = prev + 1; cur < m; cur++) {
                T[m + prev][cur] = 1;
            }

            // up[prev] -> down[cur]
            for (int cur = 0; cur < prev; cur++) {
                T[prev][m + cur] = 1;
            }
        }

        long[] init = new long[states];

        for (int last = 0; last < m; last++) {

            long upCnt = last;
            long downCnt = m - 1 - last;

            init[last] = upCnt;
            init[m + last] = downCnt;
        }

        long[][] P = matPow(T, n - 2);

        long[] finalState = multiply(init, P);

        long ans = 0;

        for (long x : finalState) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }

    private long[] multiply(long[] vec, long[][] mat) {
        int n = vec.length;
        long[] res = new long[n];

        for (int k = 0; k < n; k++) {
            if (vec[k] == 0)
                continue;

            for (int j = 0; j < n; j++) {
                if (mat[k][j] == 0)
                    continue;

                res[j] = (res[j] + vec[k] * mat[k][j]) % MOD;
            }
        }

        return res;
    }

    private long[][] matPow(long[][] base, long exp) {
        int n = base.length;

        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, base);
            }

            base = multiply(base, base);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;

        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {

            for (int k = 0; k < n; k++) {

                if (A[i][k] == 0)
                    continue;

                long aik = A[i][k];

                for (int j = 0; j < n; j++) {

                    if (B[k][j] == 0)
                        continue;

                    C[i][j] = (C[i][j] + aik * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }
}