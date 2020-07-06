class SolutionDfs {
    class Node {
        int dst;
        int price;
        public Node(int dst, int price) {
            this.dst = dst;
            this.price = price;
        }
    }
    
    int min;
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        min = Integer.MAX_VALUE;
        Map<Integer, Set<Node>> flightMap = new HashMap<>();
        for (int[] flight: flights) {
            Node cur = new Node(flight[1], flight[2]);
            Set<Node> set = flightMap.getOrDefault(flight[0], new HashSet<>());
            set.add(cur);
            flightMap.put(flight[0], set);
        }
        boolean[] visited = new boolean[n];
        dfs(src, dst, K, flightMap, visited, 0, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private void dfs(int src, int dst, int K, Map<Integer, Set<Node>> flightMap, boolean[] visited, int price, int stop) {
        if (stop > K + 1) {
            return;
        }
        if (src == dst) {
            min = Math.min(price, min);
        }
        Set<Node> set = flightMap.getOrDefault(src, new HashSet<>());
        visited[src] = true;
        for (Node node: set) {
            if (!visited[node.dst]) {
                dfs(node.dst, dst, K, flightMap, visited, price + node.price, stop + 1);
            }
        }
        visited[src] = false;
    }
    
}

// TLE

class Solution {
    class Node {
        int dst;
        int price;
        public Node(int dst, int price) {
            this.dst = dst;
            this.price = price;
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Set<Node>> flightMap = new HashMap<>();
        for (int[] flight: flights) {
            Node cur = new Node(flight[1], flight[2]);
            Set<Node> set = flightMap.getOrDefault(flight[0], new HashSet<>());
            set.add(cur);
            flightMap.put(flight[0], set);
        }
        int[][] dp = new int[K + 2][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }
        dp[0][src] = 0;
        for (int i = 0; i < K + 1; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j] = dp[i][j];
            }
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) continue;
                Set<Node> set = flightMap.getOrDefault(j, new HashSet<>()); 
                for (Node node: set) {
                    int next = node.dst;
                    dp[i + 1][next] = Math.min(dp[i + 1][next], dp[i][j] + node.price);
                }
            }
        }
        return dp[K + 1][dst] == Integer.MAX_VALUE ? -1 : dp[K + 1][dst];
    }
    
}

//ACC