class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z > x + y) return false;
        int len = x + y;
        Queue<Integer> q = new LinkedList<>();
        boolean[] canMeasure = new boolean[x + y + 1];
        boolean[] visited = new boolean[x + y + 1];
        q.offer(x);
        q.offer(y);
        while (!q.isEmpty()){
            int cur = q.poll();
            if (cur == z) return true;
            if (visited[cur]) continue;
            int a = Math.abs(cur - x);
            int b = Math.abs(cur - y);
            int c = x + cur;
            int d = y + cur;
            if (!visited[a]) q.offer(a);
            if (!visited[b]) q.offer(b);
            if (c <= len && !visited[c]) q.offer(c);
            if (d <= len && !visited[d]) q.offer(d);
            visited[cur] = true;
        }
        return false;
    }
}

// Runtime: 29 ms, faster than 13.43% of Java online submissions for Water and Jug Problem.
// Memory Usage: 34.9 MB, less than 25.40% of Java online submissions for Water and Jug Problem.
