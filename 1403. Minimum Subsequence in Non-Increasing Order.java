class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }
        int cur = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int n = nums[i];
            cur += n;
            res.add(n);
            if (cur > sum / 2) {
                return res;
            }
        }
        return res;
    }
}

// Runtime: 3 ms, faster than 98.33% of Java online submissions for Minimum Subsequence in Non-Increasing Order.
// Memory Usage: 40.3 MB, less than 100.00% of Java online submissions for Minimum Subsequence in Non-Increasing Order.