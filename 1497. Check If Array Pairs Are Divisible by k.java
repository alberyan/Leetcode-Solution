class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] frequency = new int[k];
        for(int num : arr){
            num = (num % k + k) % k;
            frequency[num]++;
        }
        if(frequency[0] % 2 != 0) return false;
        
        for (int i = 1; i <= k/2; i++) {
            if(frequency[i] != frequency[k-i]) return false;
        }
			
        return true;
    }
}

// Runtime: 7 ms, faster than 88.10% of Java online submissions for Check If Array Pairs Are Divisible by k.
// Memory Usage: 48.1 MB, less than 100.00% of Java online submissions for Check If Array Pairs Are Divisible by k.