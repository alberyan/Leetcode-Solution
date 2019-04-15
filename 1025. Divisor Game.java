class Solution {
    public boolean divisorGame(int N) {
        int[] dp = new int[N + 1];
        dp[1] = -1;
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= i; j++){
                if (i % j == 0){
                    int k = i + j;
                    if (k > N) continue;
                    if (dp[k] == 1) continue;
                    dp[k] = 0 - dp[i];
                }
            }
        }
        return dp[N] == 1;
    }
}


// Runtime: 8 ms, faster than 100.00% of Java online submissions for Divisor Game.
// Memory Usage: 31.9 MB, less than 100.00% of Java online submissions for Divisor Game.
