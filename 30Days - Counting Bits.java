class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        int[] nums = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            nums[i] = i;
        }
        while (nums[num] > 0) {
            for (int i = 1; i <= num; i++) {
                res[i] += nums[i] % 2;
                nums[i] /= 2;
            }
        }
        return res;
    }
}

//ACC