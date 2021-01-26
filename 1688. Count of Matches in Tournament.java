class Solution {
    public int numberOfMatches(int n) {
        int count = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                count += n / 2;
                n /= 2;
            } else {
                count += n / 2;
                n = n / 2 + 1;
            }
        }
        return count;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Count of Matches in Tournament.
// Memory Usage: 35.6 MB, less than 90.77% of Java online submissions for Count of Matches in Tournament.