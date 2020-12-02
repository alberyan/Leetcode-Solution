class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        int len = 1;
        while (len <= arr.length) {
            for (int i = 0; i + len - 1 < arr.length; i++) {
                for (int j = i; j < i + len; j++) {
                    res += arr[j];
                }
            }
            len += 2;
        }
        return res;
    }
}

// Runtime: 8 ms, faster than 8.38% of Java online submissions for Sum of All Odd Length Subarrays.
// Memory Usage: 39.2 MB, less than 37.47% of Java online submissions for Sum of All Odd Length Subarrays.