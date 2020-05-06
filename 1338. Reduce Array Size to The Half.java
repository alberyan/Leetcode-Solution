import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return map.getOrDefault(i2, 0) - map.getOrDefault(i1, 0);
            }
        });
        for (Integer i: map.keySet()){
            pq.offer(i);
        }
        int res = 0;
        int count = 0;
        while (count * 2 < arr.length) {
            Integer cur = pq.poll();
            count += map.getOrDefault(cur, 0);
            res++;
        }
        return res;
    }
}

// Runtime: 51 ms, faster than 46.17% of Java online submissions for Reduce Array Size to The Half.
// Memory Usage: 56.1 MB, less than 100.00% of Java online submissions for Reduce Array Size to The Half.