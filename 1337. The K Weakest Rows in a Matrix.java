import java.util.PriorityQueue;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] counts = new int[rows];
        for (int i = 0; i < rows; i++){
            int count = 0;
            for (int j = 0; j < cols; j++){
                if (mat[i][j] == 1) count++;
                else break;
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(int i1, int i2){
                if (counts[i1] > counts[i2]) return -1;
                else if (counts[i1] < counts[i2]) return 1;
                else return i2 - i1;
            }
        });
        for (int i = 0; i < rows; i++){
            pq.offer(i);
            if (pq.size() > k) pq.poll();
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }
        return res;
    }
}

// Runtime: 2 ms, faster than 90.35% of Java online submissions for The K Weakest Rows in a Matrix.
// Memory Usage: 41.6 MB, less than 100.00% of Java online submissions for The K Weakest Rows in a Matrix.