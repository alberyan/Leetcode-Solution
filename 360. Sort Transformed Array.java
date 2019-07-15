class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        double target = -1.0 * b / a / 2.0;
        int left = 0;
        int right = 0;
        if (target <= nums[0]){
        	left = -1;
        	right = 0;
        } else if (target >= nums[nums.length - 1]){
        	left = nums.length - 1;
        	right = nums.length;
        } else {
        	for (int i = 0; i < nums.length - 1; i++){
        		if (target < nums[i + 1]){
        			left = i;
        			right = i + 1;
        			break;
        		}
        	}
        }
        int[] res = new int[nums.length];
        for (int j = 0; j < nums.length; j++){
        	int i = a >= 0 ? j : nums.length - 1 - j;
        	if (left < 0){
        		res[i] = cal(nums[right], a, b, c);
        		right++;
        	} else if (right >= nums.length){
        		res[i] = cal(nums[left], a, b, c);
        		left--;
        	} else {
        		if (nums[right] - target <= target - nums[left]){
        			res[i] = cal(nums[right], a, b, c);
        			right++;
        		} else {
        			res[i] = cal(nums[left], a, b, c);
        			left--;
        		}
        	}
        }
        return res;
    }

    int cal(int num, int a, int b, int c){
    	return a * num * num + b * num + c;
    }
}

// Runtime: 1 ms, faster than 67.95% of Java online submissions for Sort Transformed Array.
// Memory Usage: 36.4 MB, less than 100.00% of Java online submissions for Sort Transformed Array.