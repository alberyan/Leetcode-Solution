class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int res = -1;
        for (int i: map.keySet()) {
            if (map.get(i) == i) {
                res = Math.max(i, res);
            }
        }
        return res;
    }
}

// Runtime: 3 ms, faster than 100.00% of Java online submissions for Find Lucky Integer in an Array.
// Memory Usage: 39.4 MB, less than 100.00% of Java online submissions for Find Lucky Integer in an Array.