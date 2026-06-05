class Solution {
    public int countPrimes(int n) {
        int last = (int) Math.sqrt(n);
        if (n <= 2)
            return 0;
        boolean[] pr = new boolean[n];
        Arrays.fill(pr, true);
        for (int i = 2; i * i < n; i++) {
            if (pr[i]) {
                for (int j = i * i; j < n; j += i) {
                    pr[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (pr[i])
                count++;
        }
        return count;

    }
}