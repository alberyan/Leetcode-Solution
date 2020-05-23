import java.awt.List;
import java.util.LinkedList;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution1 {
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

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<Integer> list = new LinkedList<>();
        int indexA = 0;
        int indexB = 0;
        while (indexA < A.length && indexB < B.length) {
            int[] curA = A[indexA];
            int[] curB = B[indexB];
            if (curA[0] > curB[1]) {
                indexB++;
                continue;
            }
            if (curA[1] < curB[0]) {
                indexA++;
                continue;
            }
            if (curA[0] < curB[0]) {
                list.add(curB[0]);
                list.add(Math.min(curA[1], curB[1]));
                if (curA[1] < curB[1]) {
                    indexA++;
                } else {
                    indexB++;
                }
                
            } else {
                list.add(curA[0]);
                list.add(Math.min(curA[1], curB[1]));
                if (curA[1] < curB[1]) {
                    indexA++;
                } else {
                    indexB++;
                }
            }
        }
        int[][] res = new int[list.size() / 2][2];
        for (int i = 0; i < list.size() / 2; i++) {
            int[] cur = new int[]{list.get(i * 2), list.get(i * 2 + 1)};
            res[i] = cur;
        }
        return res;
    }
}

// ACC
