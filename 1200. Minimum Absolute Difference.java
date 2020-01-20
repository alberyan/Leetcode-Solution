class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
    	Arrays.sort(arr);
        List<List<Integer>> res = new LinkedList<>();
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++){
        	List<Integer> cur = new ArrayList<>();
    		cur.add(arr[i]);
    		cur.add(arr[i + 1]);
        	int curDiff = cur.get(1) - cur.get(0);
        	if (curDiff < diff){
        		diff = curDiff;
        		res = new LinkedList<>();
        		res.add(cur);
        	} else if (curDiff == diff) {
        		res.add(cur);
        	}
        }
        return res;
    }
}

// Runtime: 38 ms, faster than 9.21% of Java online submissions for Minimum Absolute Difference.
// Memory Usage: 51.9 MB, less than 100.00% of Java online submissions for Minimum Absolute Difference.