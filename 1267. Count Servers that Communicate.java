class Solution {
    public int countServers(int[][] grid) {
    	int row = grid.length;;
    	int col = grid[0].length;
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        for (int i = 0; i < row; i++){
        	for (int j = 0; j < col; j++){
        		if (grid[i][j] == 1){
        			rowMap.put(i, rowMap.getOrDefault(i, 0) + 1);
        			colMap.put(j, colMap.getOrDefault(j, 0) + 1);
        		}
        	}
        }
        int res = 0;
        for (int i = 0; i < row; i++){
        	for (int j = 0; j < col; j++){
        		if (grid[i][j] == 1 && (rowMap.get(i) > 1 || colMap.get(j) > 1)) res++;
        	}
        }
        return res;
    }
}

//ACC