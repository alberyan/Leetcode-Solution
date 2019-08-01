class Solution {
    public boolean isArmstrong(int N) {
        int sum = 0;
        int tmp = N;
        int length = Integer.toString(N).length();
        while (tmp > 0){
        	sum += power(tmp % 10, length);
        	tmp /= 10;
        }
        return sum == N;
    }

    private int power(int a, int b){
    	int res = 1;
    	for (int i = 0; i < b; i++){
    		res *= a;
    	}
    	return res;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Armstrong Number.
// Memory Usage: 33 MB, less than 100.00% of Java online submissions for Armstrong Number.