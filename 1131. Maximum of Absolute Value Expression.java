class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int res = 0;
        for (int i = 0; i < arr1.length; i++){
        	for (int j = i + 1; j < arr1.length; j++){
        		res = Math.max(cal(arr1, arr2, i, j), res);
        	}
        }
        return res;
    }

    int cal(int[] arr1, int[] arr2, int i, int j){
    	return Math.abs(arr1[i] - arr1[j]) + Math.abs(arr2[i] - arr2[j]) + Math.abs(i - j);
    }

}

// O(n^2)
// Runtime: 1540 ms, faster than 100.00% of Java online submissions for Maximum of Absolute Value Expression.
// Memory Usage: 43.3 MB, less than 100.00% of Java online submissions for Maximum of Absolute Value Expression.