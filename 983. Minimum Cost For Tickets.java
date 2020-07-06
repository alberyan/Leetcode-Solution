class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length - 1] + 1];
        for (int i = 0; i < days.length; i++){
            int day = days[i];
            dp[day] = i * costs[0];
            
        }
        return dp[dp.length - 1];
    }
}
