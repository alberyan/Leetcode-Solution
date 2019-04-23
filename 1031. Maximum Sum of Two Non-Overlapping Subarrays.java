class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int len = A.length;
        int[] dp = new int[len];
        dp[0] = A[0];
        for (int i = 1; i < len; i++){
            dp[i] = A[i] + dp[i - 1];
        }
        int[] arrL = new int[len - L + 1];
        int[] arrM = new int[len - M + 1];
        arrL[0] = dp[L - 1];
        for (int i = 1; i < arrL.length; i++){
            arrL[i] = dp[i + L - 1] - dp[i - 1];
        }
        arrM[0] = dp[M - 1];
        for (int i = 1; i < arrM.length; i++){
            arrM[i] = dp[i + M - 1] - dp[i - 1];
        }
        int res = 0;
        for (int i = 0; i < arrL.length; i++){
            for (int j = 0; j < arrM.length; j++){
                if (((j >= i) && (j - i < L)) || ((i >= j) && (i - j < M))){
                    continue;
                }
                res = Math.max(res, arrL[i] + arrM[j]);
            }
        }
        return res;
    }
}

// Runtime: 4 ms, faster than 34.14% of Java online submissions for Maximum Sum of Two Non-Overlapping Subarrays.
// Memory Usage: 37.7 MB, less than 100.00% of Java online submissions for Maximum Sum of Two Non-Overlapping Subarrays.
