class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        dfs(0, graph, res, cur);
        return res;
    }
    
    private void dfs(int source, int[][] graph, List<List<Integer>> res, List<Integer> cur) {
        if (source == graph.length - 1) {
            List<Integer> copy = new LinkedList<>(cur);
            copy.add(source);
            res.add(copy);
            return;
        }
        cur.add(source);
        for (int next: graph[source]) {
            dfs(next, graph, res, cur);
        }
        cur.remove(cur.size() - 1);
    }
}

// ACC