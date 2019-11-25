class Solution {
    public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int res = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++){
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k){
				int cur = nums[i] + nums[j] + nums[k];
				res = Math.abs(res - target) < Math.abs(cur - target) ? res : cur;
				if (cur > target){
					k--;
				} else {
					j++;
				}
			}
		}
		return res;
	}
}

//ACC