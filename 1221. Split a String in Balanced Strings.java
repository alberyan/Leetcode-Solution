class Solution {
    public int balancedStringSplit(String s) {
        int res = 0;
        int lCount = 0;
        int rCount = 0;
        for (char ch: s.toCharArray()){
            if (ch == 'L') lCount++;
            else rCount++;
            if (lCount == rCount){
                res++;
                lCount = 0;
                rCount = 0;
            }
        }
        return res;
    }
}

//ACC