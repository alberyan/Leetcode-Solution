class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0;
        int cols = matrix[0].length;
        if (cols == 0) return 0;
        int res = 0;
        int[][] count = new int[rows][cols];
        for (int i = 0; i < rows; i++){
        	Arrays.fill(count[i], 1);
        }
        for (int i = 0; i < rows; i++){
        	for (int j = 0; j < cols; j++){
        		dfs(matrix, i, j, count);
        		res = Math.max(res, count[i][j]);
        	}
        }
        return res;
    }

    void dfs(int[][] matrix, int i, int j, int[][] count){
    	if (count[i][j] != 1) return;
    	int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    	for (int[] dir: dirs){
    		int newI = i + dir[0];
    		int newJ = j + dir[1];
    		if (newI < 0 || newI >= matrix.length || newJ < 0 || newJ >= matrix[0].length || matrix[newI][newJ] <= matrix[i][j]) continue;
    		dfs(matrix, newI, newJ, count);
    		count[i][j] = Math.max(count[i][j], count[newI][newJ] + 1);
    	}
    }
}

//ACC
// Runtime: 16 ms, faster than 29.54% of Java online submissions for Longest Increasing Path in a Matrix.
// Memory Usage: 41.8 MB, less than 16.33% of Java online submissions for Longest Increasing Path in a Matrix.