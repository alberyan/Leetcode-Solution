class Solution {
    public int tribonacci(int n) {
    	if (n == 0) return 0;
    	if (n <= 2) return 1;
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++){
        	dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for N-th Tribonacci Number.
// Memory Usage: 32.8 MB, less than 100.00% of Java online submissions for N-th Tribonacci Number.