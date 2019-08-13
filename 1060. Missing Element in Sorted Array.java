class Solution {
    public int missingElement(int[] nums, int k) {
        int start = nums[0];
        int index = 0;
        while (k > 0){
        	if (index < nums.length && start == nums[index]){	
        		index++;
        	} else {
        		k--;
        	}
        	start++;
        }
        return start - 1;
    }
}

// O(n)
// Runtime: 219 ms, faster than 5.10% of Java online submissions for Missing Element in Sorted Array.
// Memory Usage: 49.2 MB, less than 100.00% of Java online submissions for Missing Element in Sorted Array.