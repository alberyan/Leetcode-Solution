class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        for (int[] row: matrix){
        	StringBuilder sb = new StringBuilder();
        	if (row[0] == 0){
        		for (int i: row){
        			sb.append(i);
        		}
        	} else {
        		for (int i: row){
        			sb.append(1 - i);
        		}
        	}
        	String str = sb.toString();
        	int num = map.getOrDefault(str, 0);
        	num++;
        	res = Math.max(res, num);
        	map.put(str, num);
        }
        return res;
    }
}

// Runtime: 23 ms, faster than 89.37% of Java online submissions for Flip Columns For Maximum Number of Equal Rows.
// Memory Usage: 55.4 MB, less than 100.00% of Java online submissions for Flip Columns For Maximum Number of Equal Rows.