class Solution {
    public int longestOnes(int[] A, int K) {
        int len = 0;
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        while (zeroCount < K && right < A.length){
            if (A[right] == 0){
                zeroCount++;
            }
            right++;
            len = Math.max(len, right - left);
        }
        if (right >= A.length){
            return A.length;
        }
        while (right < A.length){
            if (A[right] == 1){
                right++;
            } else {
                while (A[left] == 1){
                    left++;
                }
                left++;
                right++;
            }
            len = Math.max(len, right - left);
        }
        return len;
    }
}
// O(N)
// Runtime: 4 ms, faster than 97.36% of Java online submissions for Max Consecutive Ones III.
// Memory Usage: 42.9 MB, less than 100.00% of Java online submissions for Max Consecutive Ones III.
