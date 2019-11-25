class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++){
        	dfs(N - 1, K, list, i);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
        	res[i] = list.get(i);
        }
        return res;
    }

    void dfs(int N, int K, List<Integer> list, int cur){
    	if (N == 0){
    		list.add(cur);
    		return;
    	}
    	int lastDigit = cur % 10;
    	if (lastDigit + K < 10){
    		dfs(N - 1, K, list, cur * 10 + lastDigit + K);
    	}
    	if (K == 0) return;
    	if (lastDigit - K >= 0){
    		dfs(N - 1, K, list, cur * 10 + lastDigit - K);
    	}
    }
}

// Runtime: 4 ms, faster than 100.00% of Java online submissions for Numbers With Same Consecutive Differences.
// Memory Usage: 36.2 MB, less than 70.00% of Java online submissions for Numbers With Same Consecutive Differences.