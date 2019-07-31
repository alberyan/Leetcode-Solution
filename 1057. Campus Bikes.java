class Solution {
	class Node {
		int dist;
		int worker;
		int bike;
		Node(int dist, int worker, int bike){
			this.dist = dist;
			this.worker = worker;
			this.bike = bike;
		}
	}

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] res = new int[workers.length];
        boolean[] takenBike = new boolean[bikes.length];
        Arrays.fill(res, -1);
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>(){
        	@Override
        	public int compare(Node n1, Node n2){
        		if (n1.dist == n2.dist){
        			if (n1.worker == n2.worker){
        				return n1.bike - n2.bike;
        			}
        			return n1.worker - n2.worker;
        		}
        		return n1.dist - n2.dist;
        	}
        });
        for (int i = 0; i < workers.length; i++){
        	for (int j = 0; j < bikes.length; j++){
        		pq.offer(new Node(dist(workers[i][0], workers[i][1], bikes[j][0], bikes[j][1]), i, j));
        	}
        }
        while (!pq.isEmpty()){
        	Node cur = pq.poll();
        	if (res[cur.worker] != -1 || takenBike[cur.bike]) continue;
        	res[cur.worker] = cur.bike;
        	takenBike[cur.bike] = true;
        }
        return res;
    }

    int dist(int x1, int y1, int x2, int y2){
    	return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}

// Runtime: 559 ms, faster than 60.19% of Java online submissions for Campus Bikes.
// Memory Usage: 89.5 MB, less than 100.00% of Java online submissions for Campus Bikes.