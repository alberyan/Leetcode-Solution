class Solution {
    public int longestRepeatingSubstring(String S) {
        int len = S.length();
        for (int i = len - 1; i >= 1; i--){
            for (int j = 0; j + i < len; j++){
                String str = S.substring(j, j + i);
                if (S.indexOf(str, j + 1) != -1) return i;
            }
        }
        return 0;
    }
}

// Runtime: 1409 ms, faster than 5.28% of Java online submissions for Longest Repeating Substring.
// Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Longest Repeating Substring.

class Solution {
    public int longestRepeatingSubstring(String S) {
        int len = S.length();
        for (int i = len - 1; i >= 1; i--){
            Set<String> set = new HashSet<>();
            for (int j = 0; j + i < len; j++){
                String str = S.substring(j, j + i);
                if (set.contains(str)) return i;
                set.add(str);
            }
            String str = S.substring(len - i);
            if (set.contains(str)) return i;
        }
        return 0;
    }
}

// Runtime: 1193 ms, faster than 5.28% of Java online submissions for Longest Repeating Substring.
// Memory Usage: 48.5 MB, less than 100.00% of Java online submissions for Longest Repeating Substring.