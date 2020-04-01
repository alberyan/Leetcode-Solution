class Solution {
    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        for (int i = lo; i <= hi; i++) {
            solve(i, map);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2) {
                if (map.get(i1) < map.get(i2)) return -1;
                if (map.get(i1) > map.get(i2)) return 1;
                return i1 - i2;
            }
        });
        for (int i = lo; i <= hi; i++) {
            pq.offer(i);
        }
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.peek();
    }
    
    private int solve(int i, Map<Integer, Integer> map) {
        if (map.get(i) != null) return map.get(i);
        int step = i % 2 == 0 ? solve(i / 2, map) : solve(i * 3 + 1, map);
        map.put(i, step + 1);
        return step + 1;
    }
}

// Runtime: 68 ms, faster than 36.32% of Java online submissions for Sort Integers by The Power Value.
// Memory Usage: 41.7 MB, less than 100.00% of Java online submissions for Sort Integers by The Power Value.