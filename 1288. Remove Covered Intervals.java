class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int end = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++){
        	if (intervals[i][1] <= end) res++;
        	else end = intervals[i][1];
        }
        return intervals.length - res;
    }
}

//ACC