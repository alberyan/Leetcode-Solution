class Solution {
    public int numTimesAllBlue(int[] light) {
        int res = 0;
        int currentLast = 0;
        for (int i = 0; i < light.length; i++) {
            currentLast = Math.max(light[i], currentLast);
            if (currentLast == i + 1) res++;
        }
        return res;
    }
}

// Runtime: 2 ms, faster than 89.34% of Java online submissions for Bulb Switcher III.
// Memory Usage: 51.3 MB, less than 100.00% of Java online submissions for Bulb Switcher III.