class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int index = 0;
        while (index < nums.length) {
            if (nums[index] == index + 1 || nums[index] == -1) {
                index++;
            } else {
                int cur = nums[index];
                if (nums[cur - 1] == cur) {
                    nums[index] = -1;
                    res.add(cur);
                    index++;
                } else {
                    swap(nums, index, cur - 1);
                }
            }
        }
        return res;
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

// ACC