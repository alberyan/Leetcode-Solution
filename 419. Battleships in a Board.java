class Solution {
    public int countBattleships(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] == 'X'){
                    if (i == 0 && j == 0) res++;
                    else if (i == 0 && j > 0 && board[i][j - 1] =='.') res++;
                    else if (j == 0 && i > 0 && board[i - 1][j] == '.') res++;
                    else if (j > 0 && board[i][j - 1] =='.' && i > 0 && board[i - 1][j] == '.') res++;
                }
            }
        }
        return res;
    }
}

// 1-pass && O(1) space
// Runtime: 1 ms, faster than 94.62% of Java online submissions for Battleships in a Board.
// Memory Usage: 43 MB, less than 52.02% of Java online submissions for Battleships in a Board.
