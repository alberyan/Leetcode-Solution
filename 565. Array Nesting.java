class Solution {
    public int arrayNesting(int[] nums) {
        int res = 0;
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            if (count[i] == -1) continue;
            if (nums[i] == i){
                res = Math.max(1, res);
                count[i] = -1;
                continue;
            }
            Set<Integer> set = new HashSet<>();
            int step = 1;
            int cur = i;
            while (true){
                set.add(cur);
                count[cur] = step;
                step++;
                cur = nums[cur];
                if (count[cur] == -1) break;
                if (count[cur] > 0){
                    res = Math.max(step - count[cur], res);
                    break;
                }
            }
            for (Integer j: set){
                count[j] = -1;
            }
        }
        return res;
    }
}

// Runtime: 9 ms, faster than 84.24% of Java online submissions for Array Nesting.
// Memory Usage: 41.6 MB, less than 83.62% of Java online submissions for Array Nesting.
