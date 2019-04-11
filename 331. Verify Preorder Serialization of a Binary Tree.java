class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder.equals("#")) return true;
        String[] arr = preorder.split(",");
        if (arr.length % 2 == 0 || arr.length < 3) return false;
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String s: arr){
            if (s.equals("#")){
                if (stack.isEmpty()) return false;
                if (stack.peekFirst().equals("#") || stack.peekFirst().equals("*")){
                    stack.pollFirst();
                    if (stack.isEmpty()) return false;
                    stack.pollFirst();
                    stack.offerFirst("*");
                    if (!removeStars(stack)) return false;
                } else {
                    stack.offerFirst(s);
                }
            } else {
                stack.offerFirst(s);
            }
        }
        return stack.isEmpty() || (stack.size() == 1 && stack.pollFirst().equals("*"));
    }

    boolean removeStars(ArrayDeque<String> stack){
        while (stack.size() > 2){
            if (stack.peekFirst().equals("*")){
                stack.pollFirst();
                if (stack.peekFirst().equals("*") || stack.peekFirst().equals("#")){
                    stack.pollFirst();
                    if (stack.isEmpty()) return false;
                    stack.pollFirst();
                    stack.offerFirst("*");
                } else {
                    stack.offerFirst("*");
                    return true;
                }
            } else {
                return true;
            }
        }
        return true;
    }
}

// Runtime: 8 ms, faster than 39.70% of Java online submissions for Verify Preorder Serialization of a Binary Tree.
// Memory Usage: 36.9 MB, less than 40.37% of Java online submissions for Verify Preorder Serialization of a Binary Tree.
