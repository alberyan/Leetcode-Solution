class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 0;
        for (int i: nums){
        	left += i / threshold;
        }
        left = Math.max(left, 1);
        int right = left;
        while (left == right) {
        	if (helper(nums, threshold, left)) return left;
        	right = left * 2;
        	if (!helper(nums, threshold, right)) left = right;
        }
        while (left < right - 1){
        	int mid = (left + right) / 2;
        	if (helper(nums, threshold, mid)) right = mid;
        	else left = mid;
        }
        return right;
    }

    private boolean helper(int[] nums, int threshold, int cur){
    	int count = 0;
        for (int num: nums){
        	if (num % cur != 0) count += num / cur + 1;
        	else count += num / cur;
        }
        return count <= threshold;
    }
}

//ACC