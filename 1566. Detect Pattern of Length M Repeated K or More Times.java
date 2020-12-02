class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        for(int i = 0, j = i + m, count = 0; j < arr.length; ++i, ++j) {
            if (arr[i] != arr[j]) {
                count = 0;
            } else if (++count == (k - 1) * m) {
                return true;
            }
        }
        return false;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Detect Pattern of Length M Repeated K or More Times.
// Memory Usage: 37.8 MB, less than 62.93% of Java online submissions for Detect Pattern of Length M Repeated K or More Times.