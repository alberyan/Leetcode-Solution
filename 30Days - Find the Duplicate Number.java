class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
		int fast = nums[slow];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		fast = 0;
		while (fast != slow) {
			fast = nums[fast];
			slow = nums[slow];
		}
		return slow;
    }
}

// ACC