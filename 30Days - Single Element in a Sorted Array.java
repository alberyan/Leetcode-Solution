class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int cur = nums[0];
        boolean dup = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur) {
                dup = true;
            } else {
                if (!dup)
                    return cur;
                cur = nums[i];
                dup = false;
            }
        }
        return cur;
    }
}

// ACC