class Solution {
    public String getPermutation(int n, int k) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] * i;
        }
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int cur = 1; cur <= n; cur++) {
                if (visited[cur]) continue;
                if (k > dp[i]) {
                    k -= dp[i];
                } else {
                    sb.append(cur);
                    visited[cur] = true;
                    break;
                }
            }
        }
        return sb.toString();
    }
}

// ACC