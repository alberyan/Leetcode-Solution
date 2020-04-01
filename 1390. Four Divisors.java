class Solution {
    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int num: nums) {
            res += fourDivisor(num);
        }
        return res;
    }

    private int fourDivisor(int num) {
        if (num % Math.sqrt(num) == 0) return 0;
        int count = 1;
        int next = -1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                next = i;
                count++;
            }
            if (count > 2) return 0;
        }
        if (next > 0) {
            return 1 + num + next + num / next;
        }
        return 0;
    }
}

// Runtime: 21 ms, faster than 83.36% of Java online submissions for Four Divisors.
// Memory Usage: 41.6 MB, less than 100.00% of Java online submissions for Four Divisors.