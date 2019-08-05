class Solution {
    public int movesToMakeZigzag(int[] nums) {
    	if (nums.length <= 1) return 1;
        return Math.min(small(nums, 0), small(nums, 1));
    }

    private int small(int[] nums, int start){
    	int res = 0;
    	for (int i = start; i < nums.length; i += 2){
    		if (i == 0){
    			res += Math.max(0, nums[i] - nums[i + 1] + 1);
    		} else if (i == nums.length - 1){
    			res += Math.max(0, nums[i] - nums[i - 1] + 1);
    		} else {
    			res += Math.max(0, nums[i] - Math.min(nums[i - 1], nums[i + 1]) + 1);
    		}
    	}
    	return res;
    }
}

// O(n)
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Decrease Elements To Make Array Zigzag.
// Memory Usage: 34.1 MB, less than 100.00% of Java online submissions for Decrease Elements To Make Array Zigzag.