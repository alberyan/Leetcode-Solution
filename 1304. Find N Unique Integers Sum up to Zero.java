class Solution {
    public int[] sumZero(int n) {
        if (n == 1) return new int[]{0};
        int[] res = new int[n];
        int count = 0;
        for (int i = 0; i < n - 1; i++){
            res[i] = i;
            count += i;
        }
        res[n - 1] = -count;
        return res;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Find N Unique Integers Sum up to Zero.
// Memory Usage: 35 MB, less than 100.00% of Java online submissions for Find N Unique Integers Sum up to Zero.