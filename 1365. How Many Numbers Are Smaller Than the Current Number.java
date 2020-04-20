class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Map<Integer, Set<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < len; i++){
            int cur = nums[i];
            Set<Integer> set = indexMap.getOrDefault(cur, new HashSet<>());
            set.add(i);
            indexMap.put(cur, set);
        }
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            if (indexMap.get(cur) == null) continue;
            Set<Integer> set = indexMap.get(cur);
            for (int num: set) {
                res[num] = i;
            }
            indexMap.remove(cur);
        }
        return res;
    }
}

// Runtime: 7 ms, faster than 40.00% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
// Memory Usage: 41.8 MB, less than 100.00% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.