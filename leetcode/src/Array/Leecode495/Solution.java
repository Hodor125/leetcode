package Array.Leecode495;

public class Solution {
    public static void main(String[] args) {
        int[] timeseries = {1,2};
        int duration = 2;
        int poisonedDuration = new Solution().findPoisonedDuration(timeseries, duration);
        System.out.println(poisonedDuration);
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if(i + 1 < timeSeries.length){
                if((timeSeries[i + 1] - timeSeries[i]) < duration)
                    count += (timeSeries[i + 1] - timeSeries[i]);
                else{
                    count += duration;
                }
            } else {
                count += duration;
            }
        }
        return count;
    }
}
