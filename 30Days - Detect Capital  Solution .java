class Solution {
    public boolean detectCapitalUse(String word) {
        if (isCapital(word.charAt(0))) {
            int count = 0;
            for (int i = 1; i < word.length(); i++) {
                if (isCapital(word.charAt(i))) count++;
            }
            return count == word.length() - 1 || count == 0;
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (isCapital(word.charAt(i))) return false;
            }
            return true;
        }
    }
    
    private boolean isCapital(char ch) {
        if (ch >= 'A' && ch <= 'Z') return true;
        return false;
    }
}

// ACC