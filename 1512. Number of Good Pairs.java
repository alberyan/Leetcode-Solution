class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int num: map.keySet()) {
            res += map.get(num) * (map.get(num) - 1);
        }
        return res / 2;
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Number of Good Pairs.
// Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for Number of Good Pairs.