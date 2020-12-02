class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (exist(board, word, visited, 0, i, j)) return true;
            }
        }
        return false;
    }
    
    private boolean exist(char[][] board, String word, boolean[][] visited, int index, int i, int j) {
        if (visited[i][j]) return false;
        if (board[i][j] != word.charAt(index)) return false;
        if (index == word.length() - 1) return true;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int rows = board.length;
        int cols = board[0].length;
        visited[i][j] = true;
        for (int[] dir: dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols) {
                if (exist(board, word, visited, index + 1, newI, newJ)) return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}

// ACC