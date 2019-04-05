class Solution {
    public String baseNeg2(int N) {
        StringBuilder sb = new StringBuilder();
        if (N == 0) return "0";
        while (N != 0){
            int digit = Math.abs(N) % 2;
            sb.append(digit);
            if (digit == 0){
                N = - (N / 2);
            } else {
                if (N > 0){
                    N = - (N / 2);
                } else {
                    N = - (N - 1) / 2;
                }
            }
        }
        return sb.reverse().toString();
    }
}
