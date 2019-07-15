class Solution {
    public int longestWPI(int[] hours) {
        int[] dp = new int[hours.length + 1];
        for (int i = 0; i < hours.length; i++){
            if (hours[i] > 8){
                dp[i + 1] = dp[i] + 1;
            } else {
                dp[i + 1] = dp[i] - 1;
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++){
            for (int j = i + 1; j < dp.length; j++){
                if (dp[j] - dp[i] > 0){
                    res = Math.max(res, j - i);
                }
            }
        }
        return res;
    }
}

// Runtime: 387 ms, faster than 100.00% of Java online submissions for Longest Well-Performing Interval.
// Memory Usage: 39.4 MB, less than 100.00% of Java online submissions for Longest Well-Performing Interval.