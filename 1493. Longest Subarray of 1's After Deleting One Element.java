class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0, j, k = 1, res = 0;
        for (j = 0; j < nums.length; ++j) {
            if (nums[j] == 0) {
                k--;
            }
            while (k < 0) {
                if (nums[i] == 0) {
                    k++;
                }
                i++;
            }
            res = Math.max(res, j - i);
        }
        return res;
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Longest Subarray of 1's After Deleting One Element.
// Memory Usage: 48.2 MB, less than 50.00% of Java online submissions for Longest Subarray of 1's After Deleting One Element.