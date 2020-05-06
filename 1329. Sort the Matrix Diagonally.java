class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        for (int row = rows - 1; row > 0; row--) {
            List<Integer> list = new ArrayList<>();
            for (int curRow = row, curCol = 0; curRow < rows && curCol < cols; curRow++, curCol++) {
                list.add(mat[curRow][curCol]);
            }
            Collections.sort(list);
            for (int curRow = row, curCol = 0; curRow < rows && curCol < cols; curRow++, curCol++) {
                mat[curRow][curCol] = list.get(curCol);
            }
        }
        for (int col = 0; col < cols; col++) {
            List<Integer> list = new ArrayList<>();
            for (int curRow = 0, curCol = col; curRow < rows && curCol < cols; curRow++, curCol++) {
                list.add(mat[curRow][curCol]);
            }
            Collections.sort(list);
            for (int curRow = 0, curCol = col; curRow < rows && curCol < cols; curRow++, curCol++) {
                mat[curRow][curCol] = list.get(curRow);
            }
        }
        return mat;
    }
}

// Runtime: 19 ms, faster than 100.00% of Java online submissions for Sort the Matrix Diagonally.
// Memory Usage: 45.2 MB, less than 100.00% of Java online submissions for Sort the Matrix Diagonally.