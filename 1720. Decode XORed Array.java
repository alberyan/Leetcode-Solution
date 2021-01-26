class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length + 1];
        res[0] = first;
        for (int i = 1; i < res.length; i++) {
            res[i] = encoded[i - 1] ^ res[i - 1];
        }
        return res;
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Decode XORed Array.
// Memory Usage: 40.2 MB, less than 75.57% of Java online submissions for Decode XORed Array.