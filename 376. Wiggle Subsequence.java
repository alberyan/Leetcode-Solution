public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return Math.max(down, up);
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Wiggle Subsequence.
// Memory Usage: 35.7 MB, less than 34.43% of Java online submissions for Wiggle Subsequence.
