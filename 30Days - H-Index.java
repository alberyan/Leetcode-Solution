class Solution {
    public int hIndex(int[] citations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int cit: citations) {
            pq.offer(cit);
        }
        int res = 0;
        while (!pq.isEmpty() && res + 1 <= pq.peek()) {
            res++;
            pq.poll();
        }
        return res;
    }
}

// ACC