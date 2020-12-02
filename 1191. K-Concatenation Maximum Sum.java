class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
    	int len = arr.length;
        int res = 0;
        int[] dp = new int[len + 1];
        for (int i = 0; i < len; i++){
        	dp[i + 1] = dp[i] + arr[i];
        }
        for (int i = 0; i < len; i++){
        		for (int j = i + 1; j < len + 1; j++){
        			res = Math.max(dp[j] - dp[i], res);
        		}
        	}
        if (k > 1){
        	for (int i = 0; i < len + 1; i++){
        		for (int j = 0; j < len + 1; j++){
        			int mid = Math.max((dp[len] * (k - 2)) % 1000000007, 0);
        			res = Math.max(res, mid + dp[j] + dp[len] - dp[i]);
        		}
        	}
        }
        return res % 1000000007;
    }
}