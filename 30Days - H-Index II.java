class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int res = 0;
        for (int i = 1; i <= len; i++) {
            int citation = citations[len - i];
            if (citation >= i) {
                res = i;
            } else {
                return res;
            }
        }
        return res;
    }
}

// ACC