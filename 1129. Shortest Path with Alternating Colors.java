class Solution {
    class Node {
        int index;
        int color; // 0: both/ 1: red/ 2: blue
        public Node(int index, int color){
            this.index = index;
            this.color = color;
        }
    }
    
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[] res = new int[n];
        Arrays.fill(res, -1);
        res[0] = 0;
        Node[] nodes = new Node[n];
        nodes[0] = new Node(0, 0);
        Map<Integer, List<Integer>> redMap = new HashMap<>();
        Map<Integer, List<Integer>> blueMap = new HashMap<>();
        for (int[] red_edge: red_edges){
            List<Integer> list = redMap.getOrDefault(red_edge[0], new ArrayList<>());
            list.add(red_edge[1]);
            redMap.put(red_edge[0], list);
        }
        for (int[] blue_edge: blue_edges){
            List<Integer> list = blueMap.getOrDefault(blue_edge[0], new ArrayList<>());
            list.add(blue_edge[1]);
            blueMap.put(blue_edge[0], list);
        }
        int step = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(nodes[0]);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Node curNode = queue.poll();
                int index = curNode.index;
                if (res[index] == -1){
                    res[index] = step;
                }
                if (curNode.color == 0){
                    addRedNode(redMap, nodes, queue, index);
                    addBlueNode(blueMap, nodes, queue, index);
                } else if (curNode.color == 1){
                    addBlueNode(blueMap, nodes, queue, index);
                } else {
                    addRedNode(redMap, nodes, queue, index);
                }
            }
            step++;
        }
        return res;
    }
    
    private void addRedNode(Map<Integer, List<Integer>> redMap, Node[] nodes, Queue<Node> queue, int index){
        List<Integer> redList = redMap.getOrDefault(index, new ArrayList<>());
        for (Integer next: redList){
            Node newNode = nodes[next];
            if (newNode == null){
                nodes[next] = new Node(next, 1);
                queue.offer(nodes[next]);
            } else if (newNode.color == 2){
                nodes[next] = new Node(next, 0);
                queue.offer(nodes[next]);
            }
        }
    }
    
    private void addBlueNode(Map<Integer, List<Integer>> blueMap, Node[] nodes, Queue<Node> queue, int index){
        List<Integer> blueList = blueMap.getOrDefault(index, new ArrayList<>());
        for (Integer next: blueList){
            Node newNode = nodes[next];
            if (newNode == null){
                nodes[next] = new Node(next, 2);
                queue.offer(nodes[next]);
            } else if (newNode.color == 1){
                nodes[next] = new Node(next, 0);
                queue.offer(nodes[next]);
            }
        }
    }
    
}


// Runtime: 5 ms, faster than 100.00% of Java online submissions for Shortest Path with Alternating Colors.
// Memory Usage: 45.3 MB, less than 100.00% of Java online submissions for Shortest Path with Alternating Colors.