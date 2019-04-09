class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int curNum = 0;
        int curStep = 1;
        int curDirIndex = 0;
        boolean shouldIncreaseStep = true;
        int[] curPos = new int[]{r0, c0};
        while (true){
            for (int i = 0; i < curStep; i++){
                int x = curPos[0];
                int y = curPos[1];
                if (x < R && x >= 0 && y < C && y >= 0){
                    res[curNum] = new int[]{x, y};
                    curNum++;
                    if (curNum >= R * C) return res;
                }
                x += dirs[curDirIndex][0];
                y += dirs[curDirIndex][1];
                curPos[0] = x;
                curPos[1] = y;
            }
            curDirIndex = (curDirIndex + 1) % 4;
            shouldIncreaseStep = !shouldIncreaseStep;
            if (shouldIncreaseStep){
                curStep++;
            }
        }
    }
}

// Runtime: 4 ms, faster than 84.42% of Java online submissions for Spiral Matrix III.
// Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Spiral Matrix III.
