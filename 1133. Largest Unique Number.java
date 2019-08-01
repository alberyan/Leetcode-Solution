class Solution {
    public int largestUniqueNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a: A){
        	map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int res = -1;
        for (Integer a: map.keySet()){
        	if (map.get(a) == 1){
        		res = Math.max(res, a);
        	}
        }
        return res;
    }
}
// Runtime: 4 ms, faster than 50.49% of Java online submissions for Largest Unique Number.
// Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for Largest Unique Number.