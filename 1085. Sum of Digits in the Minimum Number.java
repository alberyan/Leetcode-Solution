class Solution {
    public int sumOfDigits(int[] A) {
    	int min = Integer.MAX_VALUE;
        for (int i: A){
        	min = Math.min(i, min);
        }
        int res = 0;
        while (min > 0){
        	res += min % 10;
        	min /= 10;
        }
        return 1 - res % 2;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Digits in the Minimum Number.
// Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Sum of Digits in the Minimum Number.