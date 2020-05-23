class Solution {
    public int maxPower(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                dp[i] = dp[i - 1] + 1;
            }
            else {
                dp[i] = 1;
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Consecutive Characters.
// Memory Usage: 39.5 MB, less than 100.00% of Java online submissions for Consecutive Characters.