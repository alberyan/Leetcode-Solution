class Solution {
    public int removePalindromeSub(String s) {
        if (s.isEmpty()) return 0;
        if (isPalindrome(s)) return 1;
        return 2;
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 1) return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Palindromic Subsequences.
// Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Remove Palindromic Subsequences.