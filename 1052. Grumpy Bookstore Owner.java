class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int notGru = 0;
        int maxGru = 0;
        int curWindow = 0;
        int len = customers.length;
        int left = 0;
        for (int i = 0; i < len; i++){
            if (grumpy[i] == 0){
                notGru += customers[i];
            }
            if (i >= X){
                if (grumpy[left] == 1){
                    curWindow -= customers[left];
                }
                left++;
            }
            if (grumpy[i] == 1){
                curWindow += customers[i];
            }
            maxGru = Math.max(curWindow, maxGru);
        }
        return maxGru + notGru;
    }
}

// Runtime: 3 ms, faster than 100.00% of Java online submissions for Grumpy Bookstore Owner.
// Memory Usage: 41.4 MB, less than 100.00% of Java online submissions for Grumpy Bookstore Owner.
