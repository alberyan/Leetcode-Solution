class Solution {
     class Node{
         int x;
         int y;
         Node(int x, int y){
             this.x = x;
             this.y = y;
         }
     }

    public int numEnclaves(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < row; i++){
            int j = 0;
            if (A[i][j] == 1) addNode(A, i, j, q);
            j = col - 1;
            if (A[i][j] == 1) addNode(A, i, j, q);
        }

        for (int j = 0; j < col; j++){
            int i = 0;
            if (A[i][j] == 1) addNode(A, i, j, q);
            i = row - 1;
            if (A[i][j] == 1) addNode(A, i, j, q);
        }

        while (!q.isEmpty()){
            Node curNode = q.poll();
            int x = curNode.x;
            int y = curNode.y;
            if (x > 0 && A[x - 1][y] == 1) addNode(A, x - 1, y, q);
            if (x < row - 1 && A[x + 1][y] == 1) addNode(A, x + 1, y, q);
            if (y > 0 && A[x][y - 1] == 1) addNode(A, x, y - 1, q);
            if (y < col - 1 && A[x][y + 1] == 1) addNode(A, x, y + 1, q);
        }

        int res = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (A[i][j] == 1) res++;
            }
        }
        return res;
    }

    private void addNode(int[][] A, int i, int j, Queue<Node> q){
        q.offer(new Node(i, j));
        A[i][j] = 2;
    }
}
