class Solution {
    public boolean confusingNumber(int N) {
        if (N == 0) {
            return false;
        }
        int copy = N;
        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            int temp = N % 10;
            if (temp == 6 || temp == 9) {
                sb.append(temp == 6 ? 9 : 6); 
            }
            else if (temp == 0 || temp == 1 || temp == 8) {
                sb.append(temp);
            }
            else {
                return false;
            }
            
            N /= 10;
        }
        
        return Integer.parseInt(sb.toString()) != copy;
    }
}

// Runtime: 1 ms, faster than 33.11% of Java online submissions for Confusing Number.
// Memory Usage: 32.8 MB, less than 50.00% of Java online submissions for Confusing Number.