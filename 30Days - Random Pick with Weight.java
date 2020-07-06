class Solution {
    int sum;
    int[] dp;

    public Solution(int[] w) {
        dp = new int[w.length];
        dp[0] = w[0];
        for (int i = 1; i < w.length; i++){
            dp[i] = w[i] + dp[i - 1];
        }
        sum = dp[dp.length - 1];
    }
    
    public int pickIndex() {
        int cur = (int)(Math.random() * sum);
        for (int i = 0; i < dp.length; i++) {
            if (cur < dp[i]) return i;
        }
        return dp[dp.length - 1];
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

 //ACC