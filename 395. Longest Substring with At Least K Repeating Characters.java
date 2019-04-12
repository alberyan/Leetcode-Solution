class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() == 0) return 0;
        int res = 0;
        int[][] dp = new int[s.length()][26];
        dp[0][s.charAt(0) - 'a'] = 1;
        for (int i = 1; i < s.length(); i++){
            dp[i] = Arrays.copyOf(dp[i - 1], 26);
            dp[i][s.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < dp.length; i++){
            boolean flag = true;
            for (int j = 0; j < 26; j++){
                if (dp[i][j] > 0 && dp[i][j] < k){
                    flag = false;
                    break;
                }
            }
            if (flag) res = i + 1;
        }

        for (int i = 0; i < dp.length; i++){
            for (int j = i + res; j < dp.length; j++){
                boolean flag = true;
                for (int a = 0; a < 26; a++){
                    int cur = dp[j][a] - dp[i][a];
                    if (cur > 0 && cur < k){
                        flag = false;
                        break;
                    }
                }
                if (flag) res = j - i;
            }
        }

        return res;
    }
}

// Runtime: 164 ms, faster than 7.57% of Java online submissions for Longest Substring with At Least K Repeating Characters.
// Memory Usage: 37.1 MB, less than 55.17% of Java online submissions for Longest Substring with At Least K Repeating Characters.
