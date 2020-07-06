class Solution {
    class Node {
        int h;
        int k;
        public Node(int h, int k) {
            this.h = h;
            this.k = k;
        }
    }
    
    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Node n1, Node n2) {
                if (n1.h == n2.h) {
                    return n1.k - n2.k;
                } else {
                    return n2.h - n1.h;
                }
            }
        });
        for (int[] p: people) {
            Node node = new Node(p[0], p[1]);
            pq.offer(node);
        }
        List<Node> list = new LinkedList<>();
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            list.add(cur.k, cur);
        }
        int[][] res = new int[people.length][2];
        for (int i = 0; i < res.length; i++) {
            Node cur = list.get(i);
            res[i] = new int[]{cur.h, cur.k};
        }
        return res;
    }
}

//ACC