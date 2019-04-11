class Solution {
    public int superPow(int a, int[] b) {
        int res = 1;
        a = a % 1337;
        for (int i = 0; i < b.length; i++){
            res = pow(res, 10) * pow(a, b[i]) % 1337;
        }
        return res % 1337;
    }

    int pow(int a, int b){
        int res = 1;
        for (int i = 0; i < b; i++){
            res *= a;
            res %= 1337;
        }
        return res;
    }
}

// Runtime: 3 ms, faster than 86.86% of Java online submissions for Super Pow.
// Memory Usage: 40 MB, less than 10.34% of Java online submissions for Super Pow.
