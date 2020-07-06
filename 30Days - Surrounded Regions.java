import java.util.Queue;

class Solution {
    class Node {
        int i;
        int j;
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public void solve(char[][] board) {
        int rows = board.length;
        if (rows == 0) return;
        int cols = board[0].length;
        if (cols == 0) return;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Node> q = new LinkedList<>();
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = 'A';
                q.offer(new Node(0, j));
            }
            if (board[rows - 1][j] == 'O') {
                board[rows - 1][j] = 'A';
                q.offer(new Node(rows - 1, j));
            }
        }
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'A';
                q.offer(new Node(i, 0));
            }
            if (board[i][cols - 1] == 'O') {
                board[i][cols - 1] = 'A';
                q.offer(new Node(i, cols - 1));
            }
        }
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int[] dir: dirs) {
                int newI = cur.i + dir[0];
                int newJ = cur.j + dir[1];
                if (newI < rows && newI >= 0 && newJ < cols && newJ >= 0 && board[newI][newJ] == 'O') {
                    board[newI][newJ] = 'A';
                    q.add(new Node(newI, newJ));
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++){
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}

// ACC