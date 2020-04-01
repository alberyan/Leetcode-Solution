class Solution {
    public String sortString(String s) {
        int[] arr = new int[26];
        for (char ch: s.toCharArray()) {
            arr[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (count < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (arr[i] > 0) {
                    sb.append((char)(i + 'a'));
                    arr[i]--;
                    count++;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (arr[i] > 0) {
                    sb.append((char)(i + 'a'));
                    arr[i]--;
                    count++;
                }
            }
        }
        return sb.toString();
    }
}

// Runtime: 3 ms, faster than 85.71% of Java online submissions for Increasing Decreasing String.
// Memory Usage: 39.7 MB, less than 100.00% of Java online submissions for Increasing Decreasing String.