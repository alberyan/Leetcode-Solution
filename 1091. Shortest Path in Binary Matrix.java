class Solution {
	class Node {
		int x;
		int y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

    public int shortestPathBinaryMatrix(int[][] grid) {
    	int rows = grid.length;
    	if (rows <= 0 || grid[0][0] == 1 || grid[rows - 1][rows - 1] == 1) return -1;
        Queue<Node> q = new LinkedList<>();
        int len = 1;
        q.offer(new Node(0, 0));
        grid[0][0] = 1;
        while (!q.isEmpty()) {
        	Queue<Node> next = new LinkedList<>();
        	while (!q.isEmpty()){
        		Node cur = q.poll();
        		int x = cur.x;
        		int y = cur.y;
        		if (x == rows - 1 && y == rows - 1){
        			return len;
        		}
        		for (int i = -1; i <= 1; i++){
        			for (int j = -1; j <= 1; j++){
        				if (x + i >= 0 && x + i < rows && y + j >= 0 && y + j < rows && grid[x + i][y + j] == 0){
        					next.offer(new Node(x + i, y + j));
        					grid[x + i][y + j] = 1;
        				}
        			}
        		}
        	}
        	len++;
        	q = next;
        }
        return -1;
    }
}

// Runtime: 19 ms, faster than 86.22% of Java online submissions for Shortest Path in Binary Matrix.
// Memory Usage: 47.2 MB, less than 100.00% of Java online submissions for Shortest Path in Binary Matrix.