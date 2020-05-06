import java.util.PriorityQueue;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) return arr;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i: arr) {
            pq.offer(i);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int cur = pq.peek();
        int rank = 1;
        map.put(cur, rank);
        while (!pq.isEmpty()){
            int n = pq.poll();
            if (n == cur) continue;
            else {
                cur = n;
                rank++;
                map.put(cur, rank);
            }
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < res.length; i++){
            res[i] = map.get(arr[i]);
        }
        return res;
    }
}

// Runtime: 119 ms, faster than 100.00% of Java online submissions for Rank Transform of an Array.
// Memory Usage: 77.4 MB, less than 100.00% of Java online submissions for Rank Transform of an Array.