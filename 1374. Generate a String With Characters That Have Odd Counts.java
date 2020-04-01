class Solution {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i++){
                sb.append('a');
            }
            sb.append('b');
        }
        else {
            for (int i = 0; i < n; i++){
                sb.append('a');
            }
        }
        return sb.toString();
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Generate a String With Characters That Have Odd Counts.
// Memory Usage: 37.2 MB, less than 100.00% of Java online submissions for Generate a String With Characters That Have Odd Counts.