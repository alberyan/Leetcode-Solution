class Solution {
    public int confusingNumberII(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++){
            count += isConfusingNumber(i) ? 1: 0;
        }
        return count;
    }
    
    boolean isConfusingNumber(int N) {
        int res = 0;
        int tmp = N;
        while (tmp > 0){
            int digit = tmp % 10;
            tmp /= 10;
            if (digit == 2 || digit == 3 || digit == 4 || digit == 5 || digit == 7) return false;
            if (digit == 6) res = res * 10 + 9;
            else if (digit == 9) res = res * 10 + 6;
            else res = res * 10 + digit;
        }
        return res != N;
    }
}

// TLE

class Solution {
    int count;
    Set<Integer> validSet;
    public int confusingNumberII(int N) {
        count = 0;
        Integer[] array = {0, 1, 6, 8, 9};
        validSet = new HashSet<>(Arrays. asList(array));
        dfs(0, N);
        return count;
    }

    void dfs(int cur, int N){
        if (cur > N) return;
        if (isConfusingNumber(cur)) count++;
        for (int i: validSet){
            int next = cur * 10 + i;
            if (next == 0) continue;
            dfs(next, N);
        }
    }
    
    boolean isConfusingNumber(int N) {
        int res = 0;
        int tmp = N;
        while (tmp > 0){
            int digit = tmp % 10;
            tmp /= 10;
            if (digit == 6) res = res * 10 + 9;
            else if (digit == 9) res = res * 10 + 6;
            else res = res * 10 + digit;
        }
        return res != N;
    }
}