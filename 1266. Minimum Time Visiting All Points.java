class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int len = points.length;
        if (len <= 1) return 0;
        int res = 0;
        for (int i = 1; i < len; i++){
        	int xDiff = Math.abs(points[i][0] - points[i - 1][0]);
        	int yDiff = Math.abs(points[i][1] - points[i - 1][1]);
        	res += Math.max(xDiff, yDiff);
        }
        return res;
    }
}

//ACC