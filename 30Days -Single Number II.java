class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int res: map.keySet()) {
            if (map.get(res) == 1) return res;
        }
        return -1;
    }
}

// ACC