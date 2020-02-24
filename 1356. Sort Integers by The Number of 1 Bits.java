class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] tmp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++){
            tmp[i] = arr[i];
        }
        Arrays.sort(tmp, (a, b) -> bitNumber(a) - bitNumber(b) == 0 ? a - b : bitNumber(a) - bitNumber(b));
        for (int i = 0; i < arr.length; i++){
            arr[i] = tmp[i];
        }
        return arr;
    }
    
    private int bitNumber(int a){
        int res = 0;
        while (a > 0) {
            res += a % 2;
            a /= 2;
        }
        return res;
    }
}

// Runtime: 38 ms, faster than 33.33% of Java online submissions for Sort Integers by The Number of 1 Bits.
// Memory Usage: 41.3 MB, less than 100.00% of Java online submissions for Sort Integers by The Number of 1 Bits.