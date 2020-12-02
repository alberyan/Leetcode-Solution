class Solution {
    public int maxProduct(int[] nums) {
        int first = Math.max(nums[0], nums[1]);
        int second = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] >= first) {
                second = first;
                first = nums[i];
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return (first - 1) * (second - 1);
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Product of Two Elements in an Array.
// Memory Usage: 39 MB, less than 100.00% of Java online submissions for Maximum Product of Two Elements in an Array.