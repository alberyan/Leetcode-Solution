class Solution {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int originColor = grid[r0][c0];
        boolean[][] needColor = new boolean[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r0, c0});
        visited[r0][c0] = true;
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            boolean isBoundary = false;
            if (r == 0 || r == rows - 1 || c == 0 || c == cols - 1){
                isBoundary = true;
            }
            for (int i = 0; i < 4; i++){
                int newR = r + dir[i][0];
                int newC = c + dir[i][1];
                if (newR < 0 || newR >= rows || newC < 0 || newC >= cols){
                    continue;
                }
                if (grid[newR][newC] != originColor){
                    isBoundary = true;
                    continue;
                }
                if (visited[newR][newC]){
                    continue;
                }
                visited[newR][newC] = true;
                q.offer(new int[]{newR, newC});
            }
            if (isBoundary){
                needColor[r][c] = true;
            }
        }
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (needColor[i][j]){
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }
}


// Runtime: 2 ms, faster than 100.00% of Java online submissions for Coloring A Border.
// Memory Usage: 46.5 MB, less than 100.00% of Java online submissions for Coloring A Border.
