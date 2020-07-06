class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] edge: edges){
            int root1 = find(map, edge[0]);
            int root2 = find(map, edge[1]);
            if (root1 == -1 && root2 == -1){
            	map.put(edge[0], edge[0]);
            	map.put(edge[1], edge[0]);
            } else if (root1 == -1){
            	map.put(edge[0], root2);
            } else if (root2 == -1){
            	map.put(edge[1], root1);
            } else if (root1 == root2){
            	return edge;
            } else {
            	map.put(root2, root1);
            }
        }
        return edges[0];
    }

    private int find(Map<Integer, Integer> map, int child){
    	Integer parent = map.get(child);
    	if (parent == null) return -1;
    	if (parent == child) return child;
    	map.put(parent, find(map, parent));
    	return map.get(parent);
    }
}