class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while (a > 0 || b > 0 || c > 0){
            int digitA = a % 2;
            int digitB = b % 2;
            int digitC = c % 2;
            if (digitC == 1 && digitA == 0 && digitB == 0) {
                count++;
            }
            else if (digitC == 0) {
                count += digitA + digitB;
            }
            a /= 2;
            b /= 2;
            c /= 2;
        }
        return count;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Flips to Make a OR b Equal to c.
// Memory Usage: 38.7 MB, less than 100.00% of Java online submissions for Minimum Flips to Make a OR b Equal to c.