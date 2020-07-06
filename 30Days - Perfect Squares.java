class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++){
            if (i % Math.sqrt(i) == 0){
                dp[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= i / 2; j++){
                    min = Math.min(dp[j] + dp[i - j], min);
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }
}

// ACC