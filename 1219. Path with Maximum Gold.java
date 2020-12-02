class Solution {
	int max = 0;
	int[][] maxGold;

    public int getMaximumGold(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        maxGold = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++){
        	for (int j = 0; j < cols; j++){
        		if (grid[i][j] != 0 && maxGold[i][j] == 0){
        			dfs(grid, visited, i, j, 0);
        		}
        	}
        }
        return max;
    }

    void dfs(int[][] grid, boolean[][] visited, int i, int j, int count){
    	int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    	int rows = grid.length;
        int cols = grid[0].length;
    	visited[i][j] = true;
    	boolean isEnd = true;
    	count += grid[i][j];
    	for (int[] dir: dirs){
    		int nextI = i + dir[0];
    		int nextJ = j + dir[1];
    		if (nextI >= 0 && nextI < rows && nextJ >= 0 && nextJ < cols && !visited[nextI][nextJ])
    	}
    }
}