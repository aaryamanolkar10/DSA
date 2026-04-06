class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total=duration;
        for(int i=0;i<timeSeries.length-1;i++){
            total+=Math.min(timeSeries[i+1]-timeSeries[i],duration);
        }
       
        return total;
    }
}