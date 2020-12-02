class Solution {
    public int maximumSum(int[] arr) {
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
        	for (int j = i; j < arr.length; j++){
        		dp[i][j + 1] = dp[i][j] + arr[j];
        		res = Math.max(res, dp[i][j + 1]);
        	}
        }
       	for (int i = 0; i < arr.length; i++){
       		for (int j = 0; j < i; j++){
       			for (int k = i + 1; k < arr.length; k++){
       				res = Math.max(res, dp[j][k]);
       			}
       		}
       	}
        
    }
}