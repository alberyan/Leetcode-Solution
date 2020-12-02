class Solution {
    List<Integer> list;
    
    public int[] numsSameConsecDiff(int N, int K) {
        list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            helper(N - 1, K, i);
        }
        if (N == 1) list.add(0);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    
    private void helper(int N, int K, int cur) {
        if (N == 0) {
            list.add(cur);
            return;
        }
        int digit = cur % 10;
        if (digit + K < 10) {
            helper(N - 1, K, cur * 10 + digit + K);
        }
        if (digit - K >= 0 && K != 0) {
            helper(N - 1, K, cur * 10 + digit - K);
        }
    }
}

// ACC