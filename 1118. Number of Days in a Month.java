class Solution {
    public int numberOfDays(int Y, int M) {
        switch (M) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: return 31;
            case 4:
            case 6:
            case 9:
            case 11: return 30;
            case 2: {
                if (Y % 400 == 0) return 29;
                if (Y % 100 == 0) return 28;
                if (Y % 4 == 0) return 29;
                return 28;
            }
        }
        return -1;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Days in a Month.
// Memory Usage: 32.7 MB, less than 50.00% of Java online submissions for Number of Days in a Month.