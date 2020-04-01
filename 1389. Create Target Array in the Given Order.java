class Solution1 {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

// Runtime: 1 ms, faster than 16.67% of Java online submissions for Create Target Array in the Given Order.
// Memory Usage: 38 MB, less than 100.00% of Java online submissions for Create Target Array in the Given Order.