class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       	Set<Integer> notSafe = new HashSet<>();
       	Set<Integer> visited = new HashSet<>();
       	Set<Integer> tmp = new HashSet<>();
       	for (int i = 0; i < graph.length; i++){
       		if (!visited.contains(i)){
       			dfs(i, graph, notSafe, visited, tmp);
       		}
       	}
       	List<Integer> res = new ArrayList<>();
       	for (int i = 0; i < graph.length; i++){
       		if (!notSafe.contains(i)) res.add(i);
       	}
       	return res;
    }

    boolean dfs(int i, int[][] graph, Set<Integer> notSafe, Set<Integer> visited, Set<Integer> tmp){
    	visited.add(i);
    	if (tmp.contains(i)){
    		notSafe.add(i);
    		return false;
    	} 
    	tmp.add(i);
    	boolean isSafe = true;
    	for (int next: graph[i]){
    		if (!dfs(next, graph, notSafe, visited, tmp)){
    			isSafe = false;
    			break;
    		}
    	}
    	tmp.remove(i);
    	if (isSafe){
    		return true;
    	} else {
    		notSafe.add(i);
    		return false;
    	}
    }
}

// TLE