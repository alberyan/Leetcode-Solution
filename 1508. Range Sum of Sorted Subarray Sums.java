class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i + 1] = (dp[i] + nums[i]) % 1000000007;
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                pq.offer(dp[j] - dp[i]);
            }
        }
        for (int i = 1; i < left; i++) {
            pq.poll();
        }
        int res = 0;
        for (int i = left; i <= right; i++) {
            res += pq.poll();
            if (res > 1000000007) res %= 1000000007;
        }
        return res;
    }
}

// Runtime: 210 ms, faster than 41.93% of Java online submissions for Range Sum of Sorted Subarray Sums.
// Memory Usage: 54.5 MB, less than 100.00% of Java online submissions for Range Sum of Sorted Subarray Sums.