class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        k = k % (rows * cols);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rows; i++){
        	List<Integer> cur = new ArrayList<>();
        	for (int j = 0; j < cols; j++){
        		int newIndex = i * cols + j;
        		int originalIndex = (newIndex - k + (rows * cols)) % (rows * cols);
        		cur.add(grid[originalIndex / cols][originalIndex % cols]);
        	}
        	res.add(cur);
        }
        return res;
    }
}

//Acc