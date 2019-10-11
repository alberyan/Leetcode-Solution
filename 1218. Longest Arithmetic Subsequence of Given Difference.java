class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int res = 0;
        Map<Integer, Integer> dpMap = new HashMap<>();
        for (int i: arr){
        	int pre = dpMap.getOrDefault(i - difference, 0);
        	int cur = Math.max(dpMap.getOrDefault(i, 0), pre + 1);
        	dpMap.put(i, cur);
        	res = Math.max(res, cur);
        }
        return res;
    }
}

//ACC