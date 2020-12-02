class Solution {
    class Node {
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int totalFresh = 0;
        int time = 0;
        Queue<Node>cur = new LinkedList<>();
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == 1) totalFresh++;
                if (grid[i][j] == 2) {
                    cur.offer(new Node(i, j));
                }
            }
        }
        if (totalFresh == 0) return time;
    
        while (!cur.isEmpty()){
            if (totalFresh == 0) return time;
            time++;
            Queue<Node>next = new LinkedList<>();
            
            while (!cur.isEmpty()){
                Node curNode = cur.poll();
                int x = curNode.x;
                int y = curNode.y;
                if (x > 0 && grid[x - 1][y] == 1){
                    next.offer(new Node(x - 1, y));
                    grid[x - 1][y] = 2;
                }
                if (y < cols - 1 && grid[x][y + 1] == 1){
                    next.offer(new Node(x, y + 1));
                    grid[x][y + 1] = 2;
                }
                if (x < rows - 1 && grid[x + 1][y] == 1){
                    next.offer(new Node(x + 1, y));
                    grid[x + 1][y] = 2;
                }
                if (y > 0 && grid[x][y - 1] == 1){
                    next.offer(new Node(x, y - 1));
                    grid[x][y - 1] = 2;
                }
            }
            totalFresh -= next.size();
            
            cur = next;
            
        }
        return -1;
    }
}

// ACC