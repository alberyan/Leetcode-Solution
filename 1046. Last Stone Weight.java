class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone: stones){
            pq.offer(stone);
        }
        while (pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            if (a > b){
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}

// Runtime: 1 ms, faster than 98.44% of Java online submissions for Last Stone Weight.
// Memory Usage: 33.2 MB, less than 100.00% of Java online submissions for Last Stone Weight.
