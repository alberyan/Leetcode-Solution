class Solution {
    public int findTheLongestSubstring(String s) {
        int[] dp = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case 'a': dp[i + 1] = dp[i] ^ 1; break;
                case 'e': dp[i + 1] = dp[i] ^ 1 << 1; break;
                case 'i': dp[i + 1] = dp[i] ^ 1 << 2; break;
                case 'o': dp[i + 1] = dp[i] ^ 1 << 3; break;
                case 'u': dp[i + 1] = dp[i] ^ 1 << 4; break;
                default: dp[i + 1] = dp[i]; break;
            }
        }
        int res = 0;
        int lastJ = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = dp.length - 1; j >= lastJ; j--) {
                if ((dp[i] ^ dp[j]) == 0) {
                    res = Math.max(res, j - i);
                    lastJ = j;
                    break;
                }
            }
        }
        return res;
    }
}

// Runtime: 16 ms, faster than 91.94% of Java online submissions for Find the Longest Substring Containing Vowels in Even Counts.
// Memory Usage: 44.2 MB, less than 100.00% of Java online submissions for Find the Longest Substring Containing Vowels in Even Counts.