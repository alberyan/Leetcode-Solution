class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        if (nums.length == 0) {
            res.add(new LinkedList<>());
            return res;
        }
        dfs(res, cur, nums, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> cur, int[] nums, int index){
        if (index == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        dfs(res, cur, nums, index + 1);
        cur.add(nums[index]);
        dfs(res, cur, nums, index + 1);
        cur.remove(cur.size() - 1);
    }
}

// ACC