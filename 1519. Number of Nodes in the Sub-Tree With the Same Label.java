class SolutionTLE {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            if (map.get(a) == null) {
                map.put(a, new HashSet<>());
            }
            map.get(a).add(b);
            if (map.get(b) == null) {
                map.put(b, new HashSet<>());
            }
            map.get(b).add(a);
        }
        boolean[] visited = new boolean[n];
        trimTree(0, visited, map);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            traverseTree(res, i, map, labels, i);
        }
        return res;
    }
    
    private void trimTree(int cur, boolean[] visited, Map<Integer, Set<Integer>> map) {
        visited[cur] = true;
        Set<Integer> set = map.get(cur);
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] && set.contains(i)) set.remove(i);
        }
        for (int next: set) {
            trimTree(next, visited, map);
        }
        visited[cur] = false;
    }
    
    private void traverseTree(int[] res, int index, Map<Integer, Set<Integer>> map, String labels, int cur) {
        if (labels.charAt(index) == labels.charAt(cur)) res[index]++;
        Set<Integer> set = map.get(cur);
        for (int next: set) {
            traverseTree(res, index, map, labels, next);
        }
    }
}

class SolutionLTE2 {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Character, Set<Integer>> labelMap = new HashMap<>();
        Map<Integer, Set<Integer>> parentMap = new HashMap<>();
        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            if (map.get(a) == null) {
                map.put(a, new HashSet<>());
            }
            map.get(a).add(b);
            if (map.get(b) == null) {
                map.put(b, new HashSet<>());
            }
            map.get(b).add(a);
        }
        for (int i = 0; i < labels.length(); i++) {
            char ch = labels.charAt(i);
            if (labelMap.get(ch) == null) {
                labelMap.put(ch, new HashSet<>());
            }
            labelMap.get(ch).add(i);
        }
        boolean[] visited = new boolean[n];
        trimTree(0, visited, map, parentMap);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            Set<Integer> parentSet = parentMap.get(i);
            char label = labels.charAt(i);
            for (int parent: parentSet) {
                if (labelMap.get(label).contains(parent)) res[parent]++;
            }
        }
        return res;
    }
    
    private void trimTree(int cur, boolean[] visited, Map<Integer, Set<Integer>> map, Map<Integer, Set<Integer>> parentMap) {
        visited[cur] = true;
        Set<Integer> set = map.get(cur);
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] && set.contains(i)) set.remove(i);
        }
        for (int next: set) {
            trimTree(next, visited, map, parentMap);
        }
        parentMap.put(cur, new HashSet<>());
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                parentMap.get(cur).add(i);
            }
        }
        visited[cur] = false;
    }
}