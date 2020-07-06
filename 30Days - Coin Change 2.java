class SolutionTLE {
    int count;

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        count = 0;
        dfs(amount, coins, 0);
        return count;
    }

    private void dfs(int amount, int[] coins, int index) {
        if (index >= coins.length) return;
        if (amount == 0) {
            count++;
            return;
        }
        for (int i = 0; coins[index] * i <= amount; i++){
            dfs(amount - coins[index] * i, coins, index + 1);
        }
    }
}

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin: coins){
            for (int i = 1; i <= amount; i++){
                if (i >= coin){
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}

// ACC