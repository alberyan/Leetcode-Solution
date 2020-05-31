class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int[] pre: prerequisites) {
            List<Integer> list = preMap.getOrDefault(pre[0], new ArrayList<>());
            list.add(pre[1]);
            preMap.put(pre[0], list);
        }
        for (int i = 1; i <= numCourses; i++) {
            if (!dfs(i, preMap, new boolean[numCourses + 1])) return false;
        }
        return true;
    }
    
    private boolean dfs(int i, Map<Integer, List<Integer>> preMap, boolean[] visited) {
        if (preMap.get(i) == null) return true;
        for (int pre: preMap.get(i)) {
            if (visited[pre]) return false;
            visited[pre] = true;
            if (!dfs(pre, preMap, visited)) return false;
            visited[pre] = false;
        }
        return true;
    }
}

//ACC