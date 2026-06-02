class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
            int[] waterStartTime, int[] waterDuration) {

        int landThenWater = calc(
                landStartTime, landDuration,
                waterStartTime, waterDuration);

        int waterThenLand = calc(
                waterStartTime, waterDuration,
                landStartTime, landDuration);

        return Math.min(landThenWater, waterThenLand);
    }

    private int calc(int[] firstStart, int[] firstDuration,
            int[] secondStart, int[] secondDuration) {

        int earliestFinish = Integer.MAX_VALUE;

        for (int i = 0; i < firstStart.length; i++) {
            earliestFinish = Math.min(
                    earliestFinish,
                    firstStart[i] + firstDuration[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < secondStart.length; i++) {
            int finishTime = Math.max(
                    earliestFinish,
                    secondStart[i]) + secondDuration[i];

            ans = Math.min(ans, finishTime);
        }

        return ans;
    }
}