class Solution {
    public int maximum69Number (int num) {
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[3 - i] = num % 10;
            num /= 10;
        }
        for (int i = 0; i < 4; i++) {
            if (arr[i] == 6) {
                arr[i] = 9;
                break;
            }
        }
        int res = 0;
        for (int i = 0; i < 4; i++) {
            res = res * 10 + arr[i];
        }
        return res;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum 69 Number.
// Memory Usage: 39.1 MB, less than 100.00% of Java online submissions for Maximum 69 Number.