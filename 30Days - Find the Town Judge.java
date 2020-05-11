class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] arr = new int[N + 1];
        for (int[] t : trust) {
            arr[t[0]] = -1;
            if (arr[t[1]] < 0)
                continue;
            arr[t[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (arr[i] == N - 1)
                return i;
        }
        return -1;
    }
}

//ACC