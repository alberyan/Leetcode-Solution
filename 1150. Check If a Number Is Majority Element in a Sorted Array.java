class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < len){
            if (nums[left] >= target) break;
            left++;
        }
        while (right >= 0){
            if (nums[right] <= target) break;
            right--;
        }
        return (right - left + 1) > len / 2;
    }
}

// ACC