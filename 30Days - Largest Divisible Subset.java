class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int largestCount = 0;
        int largestIndex = -1;
        int[] dp = new int[nums.length];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > largestCount){
                largestCount = dp[i];
                largestIndex = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;
        fillList(dp, res, nums, largestCount, largestIndex);
        return res;
    }

    void fillList(int[] dp, List<Integer> res, int[] nums, int count, int index){
        int cur = nums[index];
        res.add(cur);
        if (count == 1) return;
        for (int i = index - 1; i >= 0; i--){
            if (cur % nums[i] == 0 && dp[i] == count - 1){
                fillList(dp, res, nums, count - 1, i);
                break;
            }
        }
    }
}


// ACC