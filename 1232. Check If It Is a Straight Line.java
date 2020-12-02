class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int len = coordinates.length;
        if (coordinates[0][0] == coordinates[1][0]){
            for (int i = 2; i < len; i++){
                if (coordinates[i][0] != coordinates[0][0]) return false;
            }
            return true;
        }
        double k = (coordinates[1][1] - coordinates[0][1] + 0.0) / (coordinates[1][0] - coordinates[0][0] + 0.0);
        for (int i = 2; i < len; i++){
            if (coordinates[i][0] == coordinates[0][0]) return false;
            if ((coordinates[i][1] - coordinates[0][1] + 0.0) / (coordinates[i][0] - coordinates[0][0] + 0.0) != k) return false;
        }
        return true;
    }
}