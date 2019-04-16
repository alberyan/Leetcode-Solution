/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length <= 1) return 0;
        Arrays.sort(intervals, (Interval i1, Interval i2) -> (i1.start - i2.start));
        int res = 0;
        Interval cur = intervals[0];
        for (int i = 1; i < intervals.length; i++){
            Interval newInterval = intervals[i];
            if (cur.end > newInterval.start){
                if (cur.end > newInterval.end){
                    cur = newInterval;
                }
                res++;
            } else {
                cur = newInterval;
            }
        }
        return res;
    }
}

// Runtime: 2 ms, faster than 97.46% of Java online submissions for Non-overlapping Intervals.
// Memory Usage: 37.8 MB, less than 94.17% of Java online submissions for Non-overlapping Intervals.
