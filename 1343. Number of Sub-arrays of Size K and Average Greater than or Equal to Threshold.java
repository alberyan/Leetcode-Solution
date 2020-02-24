class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0, right = k, sum = 0, res = 0;
        for (int i = 0; i < k; i++){
            sum += arr[i];
        }
        if (sum >= k * threshold) res++;
        while (right < arr.length) {
            sum = sum + arr[right++] - arr[left++];
            if (sum >= k * threshold) res++;
        }
        return res;
    }
}

// Runtime: 2 ms, faster than 97.95% of Java online submissions for Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold.
// Memory Usage: 57.1 MB, less than 100.00% of Java online submissions for Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold.