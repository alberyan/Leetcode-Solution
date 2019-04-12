class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++){
            int total = 0;
            for (int j = 0; j < nums.length; j++){
                if (nums[j] > i) break;
                total += dp[i - nums[j]];
            }
            dp[i] = total;
        }
        return dp[target];
    }
}

// Runtime: 1 ms, faster than 86.14% of Java online submissions for Combination Sum IV.
// Memory Usage: 35.4 MB, less than 63.41% of Java online submissions for Combination Sum IV.
