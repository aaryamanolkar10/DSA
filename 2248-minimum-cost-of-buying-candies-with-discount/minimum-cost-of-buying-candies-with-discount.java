class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int taken = 0;
        int result = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            if (taken == 2) {
                taken = 0;
            } else {
                result += cost[i];
                taken++;
            }
        }
        return result;
    }
}