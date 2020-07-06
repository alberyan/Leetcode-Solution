class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0 || target <= nums[0]) return 0;
        if (target > nums[len - 1]) return len;
        int left = 0;
        int right = len - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return right;
    }
}

// ACC