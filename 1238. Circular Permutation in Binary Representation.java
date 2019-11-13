class Solution {
    public List<Integer> circularPermutation(int n, int start) {
       	List<Integer> res = new ArrayList<>();
       	Set<Integer> visited = new HashSet<>();
       	res.add(start);
       	visited.add(start);
       	int size = 1;
       	for (int i = 0; i < n; i++) size *= 2;
       	dfs(res, visited, start, n, size);
       	return res;
    }

    private boolean dfs(List<Integer> res, Set<Integer> visited, int start, int n, int size){
    	if (res.size() == size) return true;
    	for (int i = 0; i < n; i++){
    		int next = start ^ 1 << i;
    		if (!visited.contains(next)){
    			visited.add(next);
    			res.add(next);
    			if (dfs(res, visited, next, n, size)) return true;
    			res.remove(res.size() - 1);
    			visited.remove(next);
    		}
    	}
    	return false;
    }
}

//ACC