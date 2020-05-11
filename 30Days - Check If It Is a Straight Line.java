class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) return false; 
        int[] corA = coordinates[0];
        int[] corB = coordinates[1];
        if (corA[0] == corB[0]) {
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][0] != corA[0]) return false;
            }
            return true;
        } else {
            double k = (corA[1] - corB[1] + 0.0) / (corA[0] - corB[0]);
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][0] == corA[0]) return false;
                double newK = (corA[1] - coordinates[i][1] + 0.0) / (corA[0] - coordinates[i][0]);
                if (newK != k) return false;
            }
            return true;
        }
    }
}

//ACC