class Solution {
    public int maxScore(String s) {
        int[] ones = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                if (s.charAt(i) == '1') ones[i] = 1;
            }
            else {
                if (s.charAt(i) == '1') ones[i] = ones[i - 1] + 1;
                else ones[i] = ones[i - 1];
            }
        }
        int res = 0;
        for (int i = 0; i < ones.length - 1; i++) {
            res = Math.max(res, (i + 1 - ones[i]) + (ones[ones.length - 1] - ones[i]));
        }
        return res;
    }
}

// Runtime: 1 ms, faster than 98.24% of Java online submissions for Maximum Score After Splitting a String.
// Memory Usage: 37.4 MB, less than 100.00% of Java online submissions for Maximum Score After Splitting a String.