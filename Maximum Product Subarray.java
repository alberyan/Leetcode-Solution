class Solution {
    public int maxProduct(int[] nums) {
    	int res = Integer.MIN_VALUE;
    	int start = 0;
    	int end = 0;
    	while (start < nums.length && end < nums.length){
    		while (start < nums.length && nums[start] == 0){
    			res = Math.max(res, nums[start]);
    			start++;
    		}
    		end = start + 1;
    		while (end < nums.length && nums[end] != 0){
    			res = Math.max(res, nums[end]);
    			end++;
    		}
    		if (start < nums.length){
    			res = Math.max(res, maxProduct(nums, start, end));
    		}
    		start = end;
    	}
    	return res;
    }

    int maxProduct(int[] nums, int start, int end){
    	int res = Integer.MIN_VALUE;
    	int len = end - start;
        int[] dp = new int[len + 1];
       	dp[0] = 1;
       	for (int i = 0; i < len; i++){
       		dp[i + 1] = dp[i] * nums[i + start];
       	}
       	for (int i = 0; i < len + 1; i++){
       		for (int j = i + 1; j < len + 1; j++){
       			res = Math.max(res, dp[j] / dp[i]);
       		}
       	}
       	return res;
    }
}

// ACC
// O(n^2) DP