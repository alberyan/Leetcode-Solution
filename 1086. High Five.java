class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int[] item: items){
        	PriorityQueue<Integer> pq = map.getOrDefault(item[0], new PriorityQueue<>());
        	pq.offer(item[1]);
        	if (pq.size() > 5){
        		pq.poll();
        	}
        	map.put(item[0], pq);
        }
        int[][] res = new int[map.keySet().size()][2];
        int index = 0;
        for (Integer i: map.keySet()){
        	PriorityQueue<Integer> pq = map.get(i);
        	int count = pq.size();
        	int sum = 0;
        	while (!pq.isEmpty()){
        		sum += pq.poll();
        	}
        	res[index++] = new int[]{i, sum / count};
        }
        return res;
    }
}

// Runtime: 4 ms, faster than 89.75% of Java online submissions for High Five.
// Memory Usage: 45 MB, less than 50.00% of Java online submissions for High Five.