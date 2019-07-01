class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] res = new int[1001];
        for (int[] trip: trips){
        	for (int i = trip[1]; i < trip[2]; i++){
        		res[i] += trip[0];
        		if (res[i] > capacity) return false;
        	}
        }
        return true;
    }
}

// Runtime: 8 ms, faster than 100.00% of Java online submissions for Car Pooling.
// Memory Usage: 41.9 MB, less than 100.00% of Java online submissions for Car Pooling.