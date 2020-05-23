class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                res++;
            }
        }
        return res;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Students Doing Homework at a Given Time.
// Memory Usage: 38 MB, less than 100.00% of Java online submissions for Number of Students Doing Homework at a Given Time.