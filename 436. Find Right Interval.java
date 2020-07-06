/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 import javafx.util.Pair;

class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        Map<Integer, Set<Integer>> endMap = new HashMap<>();
        for (int i = 0; i < intervals.length; i++){
            int end = intervals[i].end;
            Set<Integer> set = endMap.getOrDefault(end, new HashSet<>());
            set.add(i);
            endMap.put(i, set);
        }
        PriorityQueue<Pair<Integer, Integer>> startpq = new PriorityQueue<>((Pair p1, Pair p2) -> (p1.getKey() - p2.getKey()));
        for (int i = 0; i < intervals.length; i++){
            int start = intervals[i].start;
            Pair<Integer, Integer> pair = new Pair<>(start, i);
            startpq.offer(pair);
        }

        int[] res = new int[intervals.length];
        List<Integer> endKeyList = new ArrayList(endMap.keySet());
        Collections.sort(endKeyList);
        for (Integer endKey: endKeyList){
            Set<Integer> set = endMap.getOrDefault(endKey);
            while (!startpq.isEmpty()){
                int start = startpq.peek().getKey();
                if (start < endKey){
                    startpq.poll();
                }
            }
            int index = -1;
            if (!startpq.isEmpty()){
                index = startpq.peek().getKey();
            }
            for (Integer point: set){
                res[point] = index;
            }
        }

        return res;
    }
}
