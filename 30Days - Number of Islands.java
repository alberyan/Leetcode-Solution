class Solution {
    class Node {
        int i;
        int j;
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0, rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j] || grid[i][j] == '0') continue;
                Queue<Node> q = new LinkedList<>();
                q.offer(new Node(i, j));
                visited[i][j] = true;
                visit(q, visited, grid);
                res++;
            }
        }
        return res;
    }

    private void visit(Queue<Node> q, boolean[][] visited, char[][] grid) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int rows = grid.length, cols = grid[0].length;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int[] dir: dirs) {
                int newI = cur.i + dir[0];
                int newJ = cur.j + dir[1];
                if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols && grid[newI][newJ] == '1' && !visited[newI][newJ]) {
                    visited[newI][newJ] = true;
                    q.offer(new Node(newI, newJ));
                }
            }
        }
    }
}

//ACC