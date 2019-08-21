class NumMatrix {
	int[][] dp;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return;
        int cols = matrix[0].length;
        if (cols == 0) return;
        dp = new int[rows + 1][cols + 1];
        for (int i = 0; i < rows; i++){
        	for (int j = 0; j < cols; j++){
        		dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] - dp[i][j] + matrix[i][j];
        	}
        }
    }
    
    public void update(int row, int col, int val) {
        int pre = dp[row + 1][col + 1] - dp[row + 1][col] - dp[row][col + 1] + dp[row][col];
        int diff = val - pre;
        for (int i = row + 1; i < dp.length; i++){
        	for (int j = col + 1; j < dp[0].length; j++){
        		dp[i][j] += diff;
        	}
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */

//ACC