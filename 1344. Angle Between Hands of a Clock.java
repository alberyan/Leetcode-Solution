class Solution {
    public double angleClock(int hour, int minutes) {
        double hourHand = 360.0 / 12 * hour + 360.0 / 12 / 60 * minutes;
        double minHand = 360.0 / 60 * minutes;
        double res = Math.abs(minHand - hourHand);
        return Math.min(res, 360.0 - res);
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Angle Between Hands of a Clock.
// Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Angle Between Hands of a Clock.