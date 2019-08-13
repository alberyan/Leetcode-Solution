class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge: edges){
        	Set<Integer> endSet = map.getOrDefault(edge[0], new HashSet<>());
        	endSet.add(edge[1]);
        	map.put(edge[0], endSet);
        }
        if (map.get(destination) != null) return false;
        boolean[] visited = new boolean[n];
        visited[source] = true;
        return dfs(map, visited, source, destination);
    }

    private boolean dfs(Map<Integer, Set<Integer>> map, boolean[] visited, int source, int destination){
    	if (source == destination) return true;
    	Set<Integer> endSet = map.getOrDefault(source, new HashSet<>());
    	if (endSet.size() == 0) return false;
    	for (int endPoint: endSet){
    		if (visited[endPoint]) return false;
    		visited[endPoint] = true;
    		if (!dfs(map, visited, endPoint, destination)) return false;
    		visited[endPoint] = false;
    	}
    	return true;
    }
}

// Runtime: 16 ms, faster than 34.69% of Java online submissions for All Paths from Source Lead to Destination.
// Memory Usage: 45.2 MB, less than 100.00% of Java online submissions for All Paths from Source Lead to Destination.