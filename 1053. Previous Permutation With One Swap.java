class Solution {
    public int[] prevPermOpt1(int[] A) {
        int len = A.length;
        int left = len - 2;
        int right = len - 1;
        while (left >= 0 && A[left] <= A[left + 1]) left--;
        if (left < 0) return A;
        while (A[left] <= A[right]) right--;
        while (A[right - 1] == A[right]) right--;
        int tmp = A[left];
        A[left] = A[right];
        A[right] = tmp;
        return A;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Previous Permutation With One Swap.
// Memory Usage: 40.2 MB, less than 100.00% of Java online submissions for Previous Permutation With One Swap.