class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
                depth = Math.max(count, depth);
            }
            if (ch == ')') {
                count--;
            }
        }
        return depth;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Nesting Depth of the Parentheses.
// Memory Usage: 36.8 MB, less than 60.96% of Java online submissions for Maximum Nesting Depth of the Parentheses.