class Solution {
    public int fixedPoint(int[] A) {
        for (int i = 0; i < A.length; i++){
        	if (A[i] == i) return i;
        }
        return -1;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Fixed Point.
// Memory Usage: 37.9 MB, less than 100.00% of Java online submissions for Fixed Point.