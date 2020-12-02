class Solution {
	class Tree{
		int height;
		int x;
		int y;
		public Tree(int height, int x, int y){
			this.height = height;
			this.x = x;
			this.y = y;
		}
	}

    public int cutOffTree(List<List<Integer>> forest) {
    	int[][] forestArr = new int[forest.size()][forest.get(0).size()];
    	PriorityQueue<Tree> pq = new PriorityQueue<>((t1, t2) -> t1.height - t2.height);
        for (int i = 0; i < forest.size(); i++){
        	List<Integer> line = forest.get(i);
        	for (int j = 0; j < line.size(); j++){
        		int height = line.get(j);
        		if (height > 1){
        			pq.offer(new Tree(height, i, j));
        		}
        		forestArr[i][j] = height;
        	}
        }
        int startX = 0;
        int startY = 0;
        int res = 0;
        while (!pq.isEmpty()){
        	Tree cur = pq.poll();
        	int routeLength = cut(startX, startY, cur.x, cur.y, forestArr);
        	if (routeLength == -1){
        		return -1;
        	}
        	res += routeLength;
        	startX = cur.x;
        	startY = cur.y;
        }
        return res;
    }

    int cut(int x, int y, int desX, int desY, int[][] forestArr){
    	int rows = forestArr.length;
    	int cols = forestArr[0].length;
    	boolean[][] visited = new boolean[rows][cols];
    	int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    	int step = 0;
    	Queue<Integer[]> q = new LinkedList<>();
    	q.offer(new Integer[]{x, y});
    	while (!q.isEmpty()){
    		Queue<Integer[]> next = new LinkedList<>();
    		while (!q.isEmpty()){
    			Integer[] cur = q.poll();
    			if (cur[0] == desX && cur[1] == desY) return step;
    			for (int[] dir: dirs){
    				int newX = cur[0] + dir[0];
    				int newY = cur[1] + dir[1];
    				if (newX < 0 || newX >= rows || newY < 0 || newY >= cols || visited[newX][newY] || forestArr[newX][newY] == 0) continue;
    				next.offer(new Integer[]{newX, newY});
    				visited[newX][newY] = true;
    			}
    		}
    		step++;
    		q = next;
    	}
    	return -1;
    }
}