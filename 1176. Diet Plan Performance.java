class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int len = calories.length;
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++){
            dp[i] = dp[i - 1] + calories[i - 1];
        }
        int res = 0;
        for (int i = k; i <= len; i++){
            int cur = dp[i] - dp[i - k];
            if (cur < lower) res--;
            if (cur > upper) res++;
        }
        return res;
    }
}

// ACC