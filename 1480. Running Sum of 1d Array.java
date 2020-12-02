class Solution {
    public int[] runningSum(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
        return dp;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Running Sum of 1d Array.
// Memory Usage: 40.8 MB, less than 50.00% of Java online submissions for Running Sum of 1d Array.