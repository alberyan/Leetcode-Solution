class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        if (target < d || target > d * f) return 0;
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= d; i++){
            for (int j = i; j <= Math.min(i * f, target); j++){
                for (int k = 1; k <= f; k++){
                    if (j >= k) dp[i][j] += dp[i - 1][j - k];
                    dp[i][j] %= 1000000007;
                }
            }
        }
        return dp[d][target];
    }
}
//ACC