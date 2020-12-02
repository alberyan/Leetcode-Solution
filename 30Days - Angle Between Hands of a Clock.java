class Solution {
    public double angleClock(int hour, int minutes) {
        double hourHand = 360.0 / 12 * hour + 360.0 / 12 / 60 * minutes;
        double minHand = 360.0 / 60 * minutes;
        double res = Math.abs(minHand - hourHand);
        return Math.min(res, 360.0 - res);
    }
}

// ACC