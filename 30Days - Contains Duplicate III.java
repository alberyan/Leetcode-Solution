class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2) return false;
        for (int i = 0; i < nums.length; i++){
            for (int j = 1; j <= k && i + j < nums.length; j++){
                if (Math.abs((double)nums[i] - (double)nums[i + j]) <= (double)t) return true;
            }
        }
        return false;
    }
}

// ACC