class Solution {
    public int[] decompressRLElist(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i += 2) {
            len += nums[i];
        }
        int[] res = new int[len];
        int index = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int count = nums[i];
            int num = nums[i + 1];
            for (int j = 0; j < count; j++){
                res[index++] = num;
            }
        }
        return res;
    }
}
// Runtime: 1 ms, faster than 100.00% of Java online submissions for Decompress Run-Length Encoded List.
// Memory Usage: 38 MB, less than 100.00% of Java online submissions for Decompress Run-Length Encoded List.