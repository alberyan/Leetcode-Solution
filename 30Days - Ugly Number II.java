class Solution {
    public int nthUglyNumber(int n) {
        Set<Double> set = new HashSet<>();
        PriorityQueue<Double> pq = new PriorityQueue<>();
        pq.offer((double)(1));
        set.add((double)(1));
        while (n > 1) {
            double cur = pq.poll();
            if (set.add(cur * 2)) {
                pq.offer(cur * 2);
            }
            if (set.add(cur * 3)) {
                pq.offer(cur * 3);
            }
            if (set.add(cur * 5)) {
                pq.offer(cur * 5);
            }
            n--;
        }
        double res = pq.poll();
        return (int)(res);
    }
}

// ACC