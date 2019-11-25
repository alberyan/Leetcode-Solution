class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) return res;
        List<Integer> cur = new ArrayList<>();
        dfs(res, cur, candidates, target, 0);
        return res;
    }

    void dfs(List<List<Integer>> res, List<Integer> cur, int[] candidates, int target, int index){
    	if (target == 0) {
    		res.add(new ArrayList(cur));
    		return;
    	}
    	if (index >= candidates.length) return;
    	int size = cur.size();
    	dfs(res, cur, candidates, target, index + 1);
    	if (target >= candidates[index]){
    		cur.add(candidates[index]);
    		dfs(res, cur, candidates, target - candidates[index], index);
    		cur.remove(cur.size() - 1);
    	}
    }
}

// Runtime: 3 ms, faster than 79.02% of Java online submissions for Combination Sum.
// Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Combination Sum.