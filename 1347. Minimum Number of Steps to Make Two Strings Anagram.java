class Solution {
    public int minSteps(String s, String t) {
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        for (char ch: s.toCharArray()){
            sArr[ch - 'a']++;
        }
        for (char ch: t.toCharArray()){
            tArr[ch - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += Math.abs(sArr[i] - tArr[i]);
        }
        return res / 2;
    }
}

// Runtime: 9 ms, faster than 92.71% of Java online submissions for Minimum Number of Steps to Make Two Strings Anagram.
// Memory Usage: 42.2 MB, less than 100.00% of Java online submissions for Minimum Number of Steps to Make Two Strings Anagram.