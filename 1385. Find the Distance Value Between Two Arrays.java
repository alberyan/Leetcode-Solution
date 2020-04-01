class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int res = 0;
        for (int i: arr1) {
            if (solve(i, arr2, d)) res++;
        }
        return res;
    }
    
    private boolean solve(int i, int[] arr2, int d) {
        int left = 0;
        int right = arr2.length - 1;
        if (i <= arr2[0]) {
            return !withinD(i, arr2[0], d);
        }
        if (i >= arr2[right]) {
            return !withinD(i, arr2[right], d);
        }
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (withinD(i, arr2[mid], d)) return false;
            if (arr2[mid] <= i) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return !(withinD(i, arr2[left], d) || withinD(i, arr2[right], d));
    }
    
    private boolean withinD(int i, int j, int d) {
        return Math.abs(i - j) <= d;
    }
}

// Runtime: 2 ms, faster than 100.00% of Java online submissions for Find the Distance Value Between Two Arrays.
// Memory Usage: 41.1 MB, less than 100.00% of Java online submissions for Find the Distance Value Between Two Arrays.