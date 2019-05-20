class Solution {
    public String removeDuplicates(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch: S.toCharArray()){
            if (stack.isEmpty()){
                stack.offerLast(ch);
                continue;
            }
            char top = stack.peekLast();
            if (ch == top){
                stack.pollLast();
                continue;
            }
            stack.offerLast(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
}

// Runtime: 17 ms, faster than 79.29% of Java online submissions for Remove All Adjacent Duplicates In String.
// Memory Usage: 37.2 MB, less than 100.00% of Java online submissions for Remove All Adjacent Duplicates In String.
