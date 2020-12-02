class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        for (char ch: s.toCharArray()) {
            res = res * 26 + (ch - 'A' + 1);
        }
        return res;
    }
}

// ACC