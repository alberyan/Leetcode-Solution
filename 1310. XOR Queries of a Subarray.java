class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        int[] dp = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i + 1] = dp[i] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            res[i] = dp[end + 1] ^ dp[start];
        }
        return res;
    }
}

// Runtime: 2 ms, faster than 73.05% of Java online submissions for XOR Queries of a Subarray.
// Memory Usage: 55.5 MB, less than 100.00% of Java online submissions for XOR Queries of a Subarray.