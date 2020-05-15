class Solution {
    class Node {
        int i;
        int j;
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int rows = image.length;
        int cols = image[0].length;
        int color = image[sr][sc];
        boolean[][] visited = new boolean[rows][cols];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sr, sc));
        visited[sr][sc] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int[] dir: dirs) {
                int newI = cur.i + dir[0];
                int newJ = cur.j + dir[1];
                if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols && image[newI][newJ] == color && !visited[newI][newJ]) {
                    q.offer(new Node(newI, newJ));
                    visited[newI][newJ] = true;
                }
            }
            image[cur.i][cur.j] = newColor;
        }
        return image;
    }
}

//ACC