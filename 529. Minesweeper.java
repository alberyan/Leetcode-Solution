class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
    	int rows = board.length;
    	int cols = board[0].length;
    	int clickX = click[0];
    	int clickY = click[1];
    	if (board[clickX][clickY] == 'M') {
    		board[clickX][clickY] = 'X';
    		return board;
    	}
    	Queue<Integer[]> queue = new LinkedList<>();
    	click(board, clickX, clickY, queue);
    	while (!queue.isEmpty()){
    		Integer[] cur = queue.poll();
    		int curX = cur[0];
    		int curY = cur[1];
    		for (int i = -1; i <= 1; i++){
	    		for (int j = -1; j <= 1; j++){
	    			int newX = curX + i;
	    			int newY = curY + j;
	    			if (newX < 0 || newX >= rows || newY < 0 || newY >= cols) continue;
	    			if (board[newX][newY] == 'E'){
	    				click(board, newX, newY, queue);
	    			}
	    		}
    		}
    	}
    	return board;
    }

    void click(char[][] board, int clickX, int clickY, Queue<Integer[]> queue){
    	int rows = board.length;
    	int cols = board[0].length;
    	int count = 0;
    	for (int i = -1; i <= 1; i++){
    		for (int j = -1; j <= 1; j++){
    			int newX = clickX + i;
    			int newY = clickY + j;
    			if (newX < 0 || newX >= rows || newY < 0 || newY >= cols) continue;
    			if (board[newX][newY] == 'M'){
    				count++;
    			}
    		}
    	}
    	if (count == 0){
    		board[clickX][clickY] = 'B';
    		queue.offer(new Integer[]{clickX, clickY});
    	} else {
    		board[clickX][clickY] = (char)(count + '0');
    	}
    }
}

// Runtime: 2 ms, faster than 36.70% of Java online submissions for Minesweeper.
// Memory Usage: 38.3 MB, less than 99.48% of Java online submissions for Minesweeper.