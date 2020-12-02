class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[n * 2];
        for (int i = 0; i < n; i++) {
            res[2 * i] = nums[i];
            res[2 * i + 1] = nums[i + n];
        }
        return res;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Shuffle the Array.
// Memory Usage: 39.7 MB, less than 100.00% of Java online submissions for Shuffle the Array.