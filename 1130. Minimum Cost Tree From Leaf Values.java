class Solution {
	public int mctFromLeafValues(int[] A) {
        int res = 0, n = A.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int a : A) {
            while (stack.peek() <= a) {
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Minimum Cost Tree From Leaf Values.
// Memory Usage: 34.2 MB, less than 100.00% of Java online submissions for Minimum Cost Tree From Leaf Values.