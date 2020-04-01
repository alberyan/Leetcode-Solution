class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] flag = new int[rows][cols];
        for (int i = 0; i < rows; i++){
            int index = 0;
            for (int j = 1; j < cols; j++){
                if (matrix[i][j] < matrix[i][index]) index = j;
            }
            flag[i][index]++;
        }
        for (int j = 0; j < cols; j++) {
            int index = 0;
            for (int i = 1; i < rows; i++) {
                if (matrix[i][j] > matrix[index][j]) index = i;
            }
            flag[index][j]++;
        }
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (flag[i][j] == 2) res.add(matrix[i][j]);
            }
        }
        return res;
    }
}

// Runtime: 2 ms, faster than 67.77% of Java online submissions for Lucky Numbers in a Matrix.
// Memory Usage: 41.9 MB, less than 100.00% of Java online submissions for Lucky Numbers in a Matrix.