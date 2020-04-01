class Solution {
    public int numTeams(int[] rating) {
        int res = 0;
        int len = rating.length;
        int[] increasing = new int[len];
        int[] decreasing = new int[len];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    res += increasing[j];
                    increasing[i]++;
                }
                else {
                    res += decreasing[j];
                    decreasing[i]++;
                }
            }
        }
        return res;
    }
}

// Runtime: 2 ms, faster than 98.82% of Java online submissions for Count Number of Teams.
// Memory Usage: 37.2 MB, less than 100.00% of Java online submissions for Count Number of Teams.