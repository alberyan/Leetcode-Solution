class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return 0;
        Arrays.sort(intervals, (int[] i1, int[] i2) -> (i1[0] - i2[0]));
        int res = 0;
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++){
            int[] newInterval = intervals[i];
            if (cur[1] > newInterval[0]){
                if (cur[1] > newInterval[1]){
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

// ACC