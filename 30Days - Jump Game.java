class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int curMax = 0;
        for (int i = 0; i <= curMax; i++) {
            curMax = Math.max(curMax, i + nums[i]);
            if (curMax >= len - 1) return true;
        }
        return false;
    }
}

//ACC