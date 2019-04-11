class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 1) return 1;
        Arrays.sort(pairs, (int[] a, int[]b) -> a[0] - b[0]);
        int[] dp = new int[pairs.length];
        int res = 1;
        dp[0] = 1;
        for (int i = 1; i < pairs.length; i++){
            int len = 1;
            for (int j = 0; j < i; j++){
                if (pairs[i][0] > pairs[j][1]){
                    len = Math.max(len, dp[j] + 1);
                }
            }
            dp[i] = len;
            res = Math.max(len, res);
        }
        return res;
    }
}

// O(N^2)
// Runtime: 85 ms, faster than 25.48% of Java online submissions for Maximum Length of Pair Chain.
// Memory Usage: 51.5 MB, less than 42.53% of Java online submissions for Maximum Length of Pair Chain.
