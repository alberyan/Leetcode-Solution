class Solution1 {
    public int lastRemaining(int n) {
        boolean[] visited = new boolean[n];
        int count = 0;
        boolean skip = false;
        boolean left = true;
        int curIndex = 0;
        while (count < n - 1){
            if (left){
                while (curIndex < n && visited[curIndex]){
                    curIndex++;
                }
                if (curIndex == n){
                    left = false;
                    curIndex = n - 1;
                    skip = false;
                    continue;
                }
                if (!skip){
                    visited[curIndex] = true;
                    count++;
                }
                curIndex++;
                skip = !skip;
            } else {
                while (curIndex >= 0 && visited[curIndex]){
                    curIndex--;
                }
                if (curIndex < 0){
                    left = true;
                    curIndex = 0;
                    skip = false;
                    continue;
                }
                if (!skip){
                    visited[curIndex] = true;
                    count++;
                }
                curIndex--;
                skip = !skip;
            }
        }
        for (int i = 0; i < n; i++){
            if (!visited[i]) return i + 1;
        }
        return -1;
    }
}

// Memory Limit Exceeded
