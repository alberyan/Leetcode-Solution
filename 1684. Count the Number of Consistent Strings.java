class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allowedDig = new boolean[26];
        int res = 0;
        for (char ch: allowed.toCharArray()) {
            allowedDig[ch - 'a'] = true;
        }
        for (String word: words) {
            int count = 1;
            for (char ch: word.toCharArray()) {
                if (!allowedDig[ch - 'a']) {
                    count = 0;
                    break;
                }
            }
            res += count;
        }
        return res;
    }
}