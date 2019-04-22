class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int res = 0;
        int len = costs.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < len; i++){
            res += costs[i][0];
            pq.offer(costs[i][1] - costs[i][0]);
        }
        for (int i = 0; i < len / 2; i++){
            res += pq.poll();
        }
        return res;
    }
}

// Runtime: 1 ms, faster than 99.71% of Java online submissions for Two City Scheduling.
// Memory Usage: 37.9 MB, less than 100.00% of Java online submissions for Two City Scheduling.
