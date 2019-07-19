class Solution {
    public boolean canDivideIntoSubsequences(int[] A, int K) {
        int cur = 1, groups = 1, n = A.length;
        for (int i = 1; i < n; ++i) {
            cur = A[i - 1] < A[i] ?  1 : cur + 1;
            groups = Math.max(groups, cur);
        }
        return n >= K * groups;
    }
}

// Runtime: 5 ms, faster than 74.91% of Java online submissions for Divide Array Into Increasing Sequences.
// Memory Usage: 51.8 MB, less than 100.00% of Java online submissions for Divide Array Into Increasing Sequences.

// Explanation
// So the idea is that, find the maximum quantity of same numbers in A.
// As A is sorted already, we can do this in one pass and O(1) space.
// cur is the current length of same number until A[i].
// If A[i - 1] < A[i], we reset cur = 1. Otherwise increment cur = cur + 1.

// If n < K * groups, it's impossible to satisfy the condition, we return false.
// Otherwise, we have enough numbers in hand and we can easily meet the requirement: