class Solution {
    public int numberOfSubstrings(String s) {
        int last[] = {-1, -1, -1};
        int res = 0;
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            last[s.charAt(i) - 'a'] = i;
            res += 1 + Math.min(last[0], Math.min(last[1], last[2]));
        }
        return res;
    }
}

// Runtime: 5 ms, faster than 98.81% of Java online submissions for Number of Substrings Containing All Three Characters.
// Memory Usage: 41.7 MB, less than 100.00% of Java online submissions for Number of Substrings Containing All Three Characters.