class Solution {
    public int hammingDistance(int x, int y) {
        x ^= y;
        int res = 0;
        while (x > 0) {
            res += x % 2;
            x /= 2;
        }
        return res;
    }
}

// ACC