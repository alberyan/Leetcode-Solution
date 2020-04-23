/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0);
        int cols = dimensions.get(1);
        int cur = cols;
        for (int i = 0; i < rows; i++) {
            cur = getCur(binaryMatrix, i, cur);
            if (cur == 0) return 0;
        }
        return cur == cols ? -1: cur;
    }
    
    private int getCur(BinaryMatrix binaryMatrix, int row, int cur) {
        int left = 0;
        int right = cur - 1;
        if (binaryMatrix.get(row, left) == 1) return 0;
        if (binaryMatrix.get(row, right) == 0) return cur;
        while (left < right) {
            int mid = (left + right) / 2;
            if (binaryMatrix.get(row, mid) == 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

//ACC