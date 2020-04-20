class Solution {
    public int[] closestDivisors(int num) {
        int[] diff1 = getDivisor(num + 1);
        int[] diff2 = getDivisor(num + 2);
        return ((diff1[1] - diff1[0]) - (diff2[1] - diff2[0]) < 0) ? diff1: diff2;
    }
    
    private int[] getDivisor(int n) {
        double sqrt = Math.floor(Math.sqrt(n));
        for (int i = (int)sqrt; i >= 2; i--) {
            if (n % i == 0) return new int[]{i, n / i};
        }
        return new int[]{1, n};
    }
}

// Runtime: 9 ms, faster than 52.48% of Java online submissions for Closest Divisors.
// Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Closest Divisors