class Solution {
    Map<Integer, List<Integer>> map;

    public Solution(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
    }

    //O(1)
    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(new Random.nextInt(list.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */


 // Runtime: 125 ms, faster than 49.19% of Java online submissions for Random Pick Index.
 // Memory Usage: 54.3 MB, less than 57.54% of Java online submissions for Random Pick Index.
