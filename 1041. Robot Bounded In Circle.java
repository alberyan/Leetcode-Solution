class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        int x = 0;
        int y = 0;
        int index = 0;
        for (int i = 0; i < 4; i++){
            for (char ch: instructions.toCharArray()){
                if (ch == 'G'){
                    x += dirs[index][0];
                    y += dirs[index][1];
                }
                if (ch == 'R'){
                    index = (index + 1) % 4;
                }
                if (ch == 'L'){
                    index = (index + 4 - 1) % 4;
                }
            }
        }
        return x == 0 && y == 0;
    }
}

// Runtime: 1 ms, faster than 64.25% of Java online submissions for Robot Bounded In Circle.
// Memory Usage: 33.5 MB, less than 100.00% of Java online submissions for Robot Bounded In Circle.
