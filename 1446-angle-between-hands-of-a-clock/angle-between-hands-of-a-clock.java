class Solution {
    public double angleClock(int hour, int minutes) {
        double minutesDegree = (minutes) * 6;
        double hourDegree = (hour % 12) * 30 + (0.5) * minutes;
        double diff = Math.abs(hourDegree - minutesDegree);
        return Math.min(diff, 360 - diff);
    }
}