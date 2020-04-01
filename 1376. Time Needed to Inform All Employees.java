class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int[] timeNeedToReach = new int[n];
        Arrays.fill(timeNeedToReach, -1);
        for (int i = 0; i < n; i++) {
            find(i, timeNeedToReach, manager, informTime);
        }
        int res = 0;
        for (int i: timeNeedToReach){
            res = Math.max(i, res);
        }
        return res;
    }

    int find(int i, int[] timeNeedToReach, int[] manager, int[] informTime) {
        if (timeNeedToReach[i] != -1) {
            return timeNeedToReach[i];
        }
        if (manager[i] == -1) {
            timeNeedToReach[i] = 0;
            return 0;
        }
        timeNeedToReach[i] = find(manager[i], timeNeedToReach, manager, informTime) + informTime[manager[i]];
        return timeNeedToReach[i];
    }
}

// Runtime: 10 ms, faster than 99.57% of Java online submissions for Time Needed to Inform All Employees.
// Memory Usage: 57.1 MB, less than 100.00% of Java online submissions for Time Needed to Inform All Employees.