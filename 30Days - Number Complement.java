class Solution {
    public int findComplement(int num) {
        int cur = 1;
        int tmp = num;
        while (tmp > 0) {
            cur *= 2;
            tmp /= 2;
        }
        return cur - 1 - num;
    }
}

//ACC