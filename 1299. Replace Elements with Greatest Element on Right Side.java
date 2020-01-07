class Solution {
    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        if (len == 1) return new int[]{-1};
        int max = arr[len - 1];
        arr[len - 1] = -1;
        for (int i = len - 2; i >= 0; i--){
            int cur = arr[i];
            arr[i] = max;
            max = Math.max(cur, max);
        }
        return arr;
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Replace Elements with Greatest Element on Right Side.
// Memory Usage: 39.9 MB, less than 100.00% of Java online submissions for Replace Elements with Greatest Element on Right Side.