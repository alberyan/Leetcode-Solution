class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][2];
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((p1, p2) -> 
        	(p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]));
        for (int[] point: points){
        	pq.offer(point);
        	while (pq.size() > K){
        		pq.poll();
        	}
        }
        for (int i = 0; i < K; i++){
        	Integer[] cur = pq.poll();
        	res[i] = new int[]{cur[0], cur[1]};
        }
        return res;
    }
}