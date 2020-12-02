class Solution {
    int largest;
    
    public String largestTimeFromDigits(int[] A) {
        largest = -1;
        boolean[] visited = new boolean[4];
        dfs(0, A, visited, 0);
        if (largest == -1) return "";
        return String.format("%02d:%02d", largest / 100, largest % 100);
    }
    
    private void dfs(int cur, int[] A, boolean[] visited, int index) {
        for (int i = 0; i <= 3; i++) {
            if (visited[i]) continue;
            int tmp = cur * 10 + A[i];
            if (index == 1) {
                if (tmp > 23) continue;
                else {
                    visited[i] = true;
                    dfs(tmp, A, visited, index + 1);
                    visited[i] = false;
                }
            } else if (index == 3) {
                if (tmp % 100 > 59) continue;
                else {
                    largest = Math.max(largest, tmp);
                }
            } else {
                visited[i] = true;
                dfs(tmp, A, visited, index + 1);
                visited[i] = false;
            }
        }
    }
}

// ACC