class Solution {
    public int minFallingPathSum(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        for (int i = 1; i < row; i++){
            A[i][0] = A[i][0] + Math.min(A[i - 1][0], A[i - 1][1]);
            for (int j = 1; j < col - 1; j++){
                A[i][j] = A[i][j] + Math.min(Math.min(A[i - 1][j], A[i - 1][j - 1]), A[i - 1][j + 1]);
            }
            int j = col - 1;
            A[i][j] = A[i][j] + Math.min(A[i - 1][j], A[i - 1][j - 1]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++){
            res = Math.min(res, A[row - 1][i]);
        }
        return res;
    }
}


// Runtime: 3 ms, faster than 97.23% of Java online submissions for Minimum Falling Path Sum.
// Memory Usage: 40 MB, less than 63.44% of Java online submissions for Minimum Falling Path Sum.
