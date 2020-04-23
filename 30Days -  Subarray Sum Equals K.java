class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int[] dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++){
            dp[i + 1] = dp[i] + nums[i];
        }
        for (int i = 0; i < dp.length; i++){
            for (int j = i + 1; j < dp.length; j++){
                if (dp[j] - dp[i] == k) res++;
            }
        }
        return res;
    }
}

//ACC