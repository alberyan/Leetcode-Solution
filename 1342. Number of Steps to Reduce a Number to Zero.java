class Solution {
    public int numberOfSteps (int num) {
        int res = 0;
        while (num > 0) {
            if (num % 2 == 0) num /= 2;
            else num--;
            res++;
        }
        return res;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Steps to Reduce a Number to Zero.
// Memory Usage: 36 MB, less than 100.00% of Java online submissions for Number of Steps to Reduce a Number to Zero.