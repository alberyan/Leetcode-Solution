class Solution {
    public String tictactoe(int[][] moves) {
        char[][] board = new char[3][3];
        for (int i = 0; i < moves.length; i++){
            char ch = i % 2 == 0 ? 'X' : 'O';
            board[moves[i][0]][moves[i][1]] = ch;
        }
        if (board[0][0] == board[0][1] && board[0][0] == board[0][2]){
            if (board[0][0] == 'X') return "A";
            if (board[0][0] == 'O') return "B";
        }
        else if (board[0][0] == board[1][1] && board[0][0] == board[2][2]){
            if (board[0][0] == 'X') return "A";
            if (board[0][0] == 'O') return "B";
        }
        else if (board[0][0] == board[1][0] && board[0][0] == board[2][0]){
            if (board[0][0] == 'X') return "A";
            if (board[0][0] == 'O') return "B";
        }
        else if (board[0][1] == board[1][1] && board[0][1] == board[2][1]){
            if (board[0][1] == 'X') return "A";
            if (board[0][1] == 'O') return "B";
        }
        else if (board[0][2] == board[1][2] && board[0][2] == board[2][2]){
            if (board[0][2] == 'X') return "A";
            if (board[0][2] == 'O') return "B";
        }
        else if (board[1][0] == board[1][1] && board[1][0] == board[1][2]){
            if (board[1][0] == 'X') return "A";
            if (board[1][0] == 'O') return "B";
        }
        else if (board[2][0] == board[2][1] && board[2][0] == board[2][2]){
            if (board[2][0] == 'X') return "A";
            if (board[2][0] == 'O') return "B";
        }
        else if (board[0][2] == board[1][1] && board[0][2] == board[2][0]){
            if (board[0][2] == 'X') return "A";
            if (board[0][2] == 'O') return "B";
        }
        else if (moves.length == 9) return "Draw";
        return "Pending";
    }
}

//acc