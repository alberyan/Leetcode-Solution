class Solution {
    public int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int[] leftToRight = new int[len];
        int[] rightToLeft = new int[len];
        Arrays.fill(leftToRight, -1);
        Arrays.fill(rightToLeft, -1);
        if (seats[0] == 1) leftToRight[0] = 0;
        for (int i = 1; i < len; i++){
            if (seats[i] == 1) leftToRight[i] = 0;
            else if (leftToRight[i - 1] == -1) leftToRight[i] = -1;
            else leftToRight[i] = leftToRight[i - 1] + 1;
        }
        if (seats[len - 1] == 1) rightToLeft[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--){
            if (seats[i] == 1) rightToLeft[i] = 0;
            else if (rightToLeft[i + 1] == -1) rightToLeft[i] = -1;
            else rightToLeft[i] = rightToLeft[i + 1] + 1;
        }
        int res = 0;
        for (int i = 0; i < len; i++){
            if (leftToRight[i] == -1) res = Math.max(res, rightToLeft[i]);
            else if (rightToLeft[i] == -1) res = Math.max(res, leftToRight[i]);
            else res = Math.max(res, Math.min(rightToLeft[i], leftToRight[i]));
        }
        return res;
    }
}

//Acc
//O(n)