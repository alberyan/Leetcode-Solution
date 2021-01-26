class Solution {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            if (k >= 0) {
                for (int j = 1; j <= k; j++) {
                    int index = (i + j) % len;
                    res[i] += code[index];
                }
            } else {
                for (int j = k; j < 0; j++) {
                    int index = (i + j + len) % len;
                    res[i] += code[index];
                }
            }
        }
        return res;
    }
}