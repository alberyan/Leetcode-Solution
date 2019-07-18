class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i: nums){
        	sum += i;
        }
        if (sum % k != 0) return false;
        boolean[] visited = new boolean[nums.length];
        return dfs(nums, visited, 0, 0, 0, sum / k);
    }

    boolean dfs(int[] nums, boolean[] visited, int start, int curSum, int usedCount, int target){
    	if (usedCount == nums.length) return true;
    	int len = visited.length;
    	boolean res = false;
    	for (int i = start; i < len; i++){
    		if (visited[i]) continue;
    		if (nums[i] + curSum > target) continue;
    		visited[i] = true;
    		if (nums[i] + curSum == target) res |= dfs(nums, visited, 0, 0, usedCount + 1, target);
    		else res |= dfs(nums, visited, i + 1, nums[i] + curSum, usedCount + 1, target);
    		if (res == true) return true;
    		visited[i] = false;
    	}
    	return res;
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Partition to K Equal Sum Subsets.
// Memory Usage: 34.3 MB, less than 89.84% of Java online submissions for Partition to K Equal Sum Subsets.