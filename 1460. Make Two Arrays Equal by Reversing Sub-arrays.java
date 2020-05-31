class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i: target) {
            map.put(i, map.getOrDefault(i, 0) - 1);
            if (map.get(i) < 0) return false;
        }
        return true;
    }
}

// Runtime: 5 ms, faster than 100.00% of Java online submissions for Make Two Arrays Equal by Reversing Sub-arrays.
// Memory Usage: 39.9 MB, less than 100.00% of Java online submissions for Make Two Arrays Equal by Reversing Sub-arrays.