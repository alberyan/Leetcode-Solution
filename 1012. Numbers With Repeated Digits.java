
// O(NlgN)
// Time Limit Exceeded
class Solution {
    public int numDupDigitsAtMostN(int N) {
        int count = 0;
        if (N <= 10) return 0;
        for (int i = 11; i <= N; i++){
            count += repeat(i) ? 1: 0;
        }
        return count;
    }

    boolean repeat(int i){
        boolean[] digit = new boolean[10];
        while (i > 0){
            int d = i % 10;
            if (digit[d]) return true;
            digit[d] = true;
            i = i / 10;
        }
        return false;
    }
}
