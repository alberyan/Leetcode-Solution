class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] res = new int[R * C][2];
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r0, c0});
        visited[r0][c0] = true;
        int index = 0;
        while (!q.isEmpty()){
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++){
                int newX = cur[0] + dir[i][0];
                if (newX >= R || newX < 0) continue;
                int newY = cur[1] + dir[i][1];
                if (newY >= C || newY < 0) continue;
                if (!visited[newX][newY]){
                    q.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
            res[index][0] = cur[0];
            res[index][1] = cur[1];
            index++;
        }
        return res;
    }
}

// Runtime: 8 ms, faster than 92.84% of Java online submissions for Matrix Cells in Distance Order.
// Memory Usage: 39.5 MB, less than 100.00% of Java online submissions for Matrix Cells in Distance Order.
