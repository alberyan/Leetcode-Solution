class Solution {
    class Node {
        int x;
        int y;
        int dis;
        Node(int x, int y){
            this.x = x;
            this.y = y;
            this.dis = x * x + y * y;
        }
    }
    
    public int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][2];
        PriorityQueue<Node> pq = new PriorityQueue<>(new DisComparator());
        for (int[] point: points){
            pq.offer(new Node(point[0], point[1]));
            if (pq.size() > K){
                pq.poll();
            }
        }
        for (int i = K - 1; i >= 0; i--){
            Node cur = pq.poll();
            res[i][0] = cur.x;
            res[i][1] = cur.y;
        }
        return res;
    }
    
    class DisComparator implements Comparator<Node>{
        @Override
            public int compare(Node n1, Node n2){
                if (n1.dis > n2.dis) return -1;
                else if (n1.dis < n2.dis) return 1;
                else return 0;
            }
    }

}

// ACC