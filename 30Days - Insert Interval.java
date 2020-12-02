import java.util.ArrayDeque;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] ints = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            ints[i] = intervals[i];
        }
        ints[ints.length - 1] = newInterval;
        Arrays.sort(ints, (i1, i2) -> (i1[0] - i2[0]));
        int index = 0;
        int[][] res1 = new int[intervals.length + 1][2];
        res1[0] = ints[0];
        for (int i = 1; i < ints.length; i++) {
            if (res1[index][1] >= ints[i][0]) {
                res1[index][1] = Math.max(res1[index][1], ints[i][1]);
            } else {
                res1[++index] = ints[i];
            }
        }
        int[][] res = new int[index + 1][2];
        for (int i = 0; i < index + 1; i++){
            res[i] = res1[i];
        }
        return res;
    }
}

// ACC