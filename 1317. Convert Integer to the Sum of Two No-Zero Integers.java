class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int a = 1; a <= n / 2; a++){
            if (!containZero(n - a) && !containZero(a)) return new int[]{a, n - a};
        }
        return new int[]{0, n};
    }

    private boolean containZero(int n) {
        for (int i = 1; i < n; i *= 10) {
            if (n / i % 10 == 0) return true;
        }
         return false;
    }
}

// Runtime: 1 ms, faster than 97.71% of Java online submissions for Convert Integer to the Sum of Two No-Zero Integers.
// Memory Usage: 34.7 MB, less than 100.00% of Java online submissions for Convert Integer to the Sum of Two No-Zero Integers.