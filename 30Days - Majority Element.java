class Solution {
    public int majorityElement(int[] nums) {
        int cur = 0;
        int count = 0;
        for (int num: nums) {
            if (cur == num) {
                count++;
            } else {
                count--;
                if (count < 0) {
                    cur = num;
                    count = 1;
                }
            }
        }
        return cur;
    }
}

// ACC