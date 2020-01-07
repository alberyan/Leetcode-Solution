class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        int[] arr = new int[9];
        for (int i = 1; i <= 9; i++){
        	arr[i - 1] = i;
        }
        for (int i = 2; i <= 9; i++){
        	for (int j = 0; j < 9; j++){
        		if (i + j > 9) break;
        		arr[j] = arr[j] * 10 + i + j;
        		if (arr[j] >= low && arr[j] <= high) res.add(arr[j]);
        		if (arr[j] > high) return res;
        	}
        }
        return res;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Sequential Digits.
// Memory Usage: 33.3 MB, less than 100.00% of Java online submissions for Sequential Digits.