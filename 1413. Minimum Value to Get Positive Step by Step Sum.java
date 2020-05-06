class Solution {
    public int minStartValue(int[] nums) {
        int len = nums.length, cur = 0, min = 0;
        for (int i = 0; i < len; i++) {
            cur += nums[i];
            min = Math.min(min, cur);
        }
        return min >= 0 ? 1 : 1 - min;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Value to Get Positive Step by Step Sum.
// Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Minimum Value to Get Positive Step by Step Sum.