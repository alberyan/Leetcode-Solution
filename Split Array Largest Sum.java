class Solution {
	int res;
    public int splitArray(int[] nums, int m) {
    	res = Integer.MAX_VALUE;
        int len = nums.length;
        int[] dp = new int[len + 1];
        for (int i = 0; i < len; i++){
        	dp[i + 1] = dp[i] + nums[i];
        }
        dfs(dp, 0, m, 0);
        return res;
    }

    void dfs(int[] dp, int start, int m, int curMax){
    	if (start == dp.length - 1){
    		if (m == 0) res = Math.min(curMax, res);
    		return;
    	}
    	if (m == 0) return;
    	for (int i = start + 1; i < dp.length; i++){
    		int cur = dp[i] - dp[start];
    		if (cur > res) break;
    		curMax = Math.max(cur, curMax);
    		dfs(dp, i, m - 1, curMax);
    	}
    }
}