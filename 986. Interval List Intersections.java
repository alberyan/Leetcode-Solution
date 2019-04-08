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
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> list = new ArrayList<>();
        int indexA = 0;
        int indexB = 0;
        while (indexA < A.length && indexB < B.length){
            Interval intA = A[indexA];
            Interval intB = B[indexB];
            if (intA.end < intB.start){
                indexA++;
            } else if (intA.start > intB.end){
                indexB++;
            } else {
                Interval newInt = new Interval(Math.max(intA.start, intB.start), Math.min(intA.end, intB.end));
                list.add(newInt);
                if (intA.end <= intB.end){
                    indexA++;
                } else {
                    indexB++;
                }
            }
        }
        Interval[] res = new Interval[list.size()];
        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}

// Runtime: 2 ms, faster than 99.92% of Java online submissions for Interval List Intersections.
// Memory Usage: 46.7 MB, less than 43.11% of Java online submissions for Interval List Intersections.
