class Solution {
    public int[] plusOne(int[] digits) {
        int add = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += add;
            if (digits[i] == 10) {
                digits[i] = 0;
            }
            else {
                return digits;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}

// ACC