class Solution {
    public int brokenCalc(int X, int Y) {
        int step = 0;
        if (X > Y){
            return X - Y;
        }
        int power = 1;
        while (X < Y){
            X *= 2;
            step++;
            power *= 2;
        }
        int dif = X - Y;
        while (dif > 0){
            while (dif >= power){
                dif -= power;
                step++;
            }
            power /= 2;
        }
        return step;
    }
}

// Runtime: 8 ms, faster than 7.20% of Java online submissions for Broken Calculator.
// Memory Usage: 31.8 MB, less than 100.00% of Java online submissions for Broken Calculator.
