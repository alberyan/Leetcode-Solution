class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> (map.get(i2) - map.get(i1)));
        for (int num: map.keySet()) {
            pq.offer(num);
        }
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}

// ACC