class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        int res = -1;
        for (int i = 0; i < A.length; i++){
        	for (int j = i + 1; j < A.length; j++){
        		if (A[i] + A[j] < K) res = Math.max(A[i] + A[j], res);
        	}
        }
        return res;
    }
}

// Runtime: 2 ms, faster than 47.15% of Java online submissions for Two Sum Less Than K.
// Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Two Sum Less Than K.