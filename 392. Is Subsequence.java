class Solution {
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;
        while (tIndex < t.length() && sIndex < s.length()){
            if (s.charAt(sIndex) == t.charAt(tIndex)){
                sIndex++;
            }
            tIndex++;
        }
        if (sIndex == s.length()) return true;
        return false;
    }
}

//Runtime: 17 ms, faster than 56.40% of Java online submissions for Is Subsequence.
// Memory Usage: 51.2 MB, less than 24.55% of Java online submissions for Is Subsequence.
