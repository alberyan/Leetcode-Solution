class Solution {
	public int[] largestSubarraySum(int[] arr){
		if (arr.length <= 1) return arr;
		int len = arr.length;
		int[] dp = new int[len];
		dp[0] = arr[0];
		for (int i = 1; i < len; i++){
			dp[i] = dp[i - 1] + arr[i];
		}
		int maxSum = Integer.MIN_VALUE;
		int left = -1;
		int right = 0;
		for (int i = 0; i < len; i++){
			if (maxSum < arr[i]){
				maxSum = arr[i];
				right = i;
			}
		}
		for (int i = 0; i < len; i++){
			for (int j = i + 1; j < len; j++){
				if (maxSum < arr[j] - arr[i]){
					maxSum = arr[j] - arr[i];
					left = i;
					right = j;
				}
			}
		}
		int[] res = new int[right - left];
		for (int i = 0; i < res.length; i++){
			res[i] = arr[i + left + 1];
		}
		return res;
	}
}