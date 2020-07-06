class Solution {
    public int smallestFactorization(int a) {
        if (a <= 0) return 0;
        if (a < 10) return a;
        Stack<Integer> stack = new Stack<>();
        double res = 0;
        while (a > 1){
            boolean hasDivided = false;
            for (int i = 9; i >= 2; i--){
                if (a % i == 0){
                    a /= i;
                    stack.push(i);
                    hasDivided = true;
                    break;
                }
            }
            if (!hasDivided) return 0;
        }
        while (!stack.isEmpty()){
            res = res * 10 + stack.pop();
        }
        return res <= (double)Integer.MAX_VALUE ? (int)res : 0;
    }
}