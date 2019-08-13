class Solution {
    int min = Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {
        dfs(new boolean[bikes.length], workers, 0, bikes, 0);
        return min;
    }
    public void dfs(boolean[] visit, int[][] workers, int i, int[][] bikes, int distance) {
        if (i >= workers.length) {
            min = Math.min(distance, min);
            return ;
        }
        if (distance > min) {
            return ;
        }
        for (int j = 0; j < bikes.length; j++) {
            if (visit[j]) {
                continue;
            }
            visit[j] = true;
            dfs(visit, workers, i + 1, bikes, distance + dis(bikes[j], workers[i]));
            visit[j] = false;
        }
        
    }
    public int dis(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}

//dfs
// Runtime: 215 ms, faster than 42.66% of Java online submissions for Campus Bikes II.
// Memory Usage: 34.1 MB, less than 100.00% of Java online submissions for Campus Bikes II.