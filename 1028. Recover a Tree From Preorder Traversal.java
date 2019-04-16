/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode recoverFromPreorder(String S) {
        if (S.length() == 0){
            return null;
        }
        int index = 0;
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (index < S.length()){
            if (index == 0) sb.append(S.charAt(index));
            else {
                if (S.charAt(index - 1) != '-' && S.charAt(index) == '-'){
                    list.add(sb.toString());
                    sb = new StringBuilder();
                } else if (S.charAt(index - 1) == '-' && S.charAt(index) != '-'){
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
                sb.append(S.charAt(index));
            }
            index++;
        }
        list.add(sb.toString());

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerLast(new TreeNode(Integer.valueOf(list.get(0))));
        for (int i = 1; i < list.size(); i += 2){
            int layer = list.get(i).length();
            TreeNode newNode = new TreeNode(Integer.valueOf(list.get(i + 1)));
            while (stack.size() > layer){
                stack.pollLast();
            }
            TreeNode curRoot = stack.peekLast();
            if (curRoot.left == null){
                curRoot.left = newNode;
            } else {
                curRoot.right = newNode;
            }
            stack.offerLast(newNode);
        }
        while (stack.size() > 1){
            stack.pollLast();
        }
        return stack.pollLast();
    }
}

// Runtime: 20 ms, faster than 14.29% of Java online submissions for Recover a Tree From Preorder Traversal.
// Memory Usage: 38.8 MB, less than 100.00% of Java online submissions for Recover a Tree From Preorder Traversal.
