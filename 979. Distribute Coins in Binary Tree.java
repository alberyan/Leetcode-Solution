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
    public int distributeCoins(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.abs(distribute(root)[0]);
    }

    int[] distribute(TreeNode root){
        if (root == null) return new int[]{0, 0};
        int move = 0;
        int extraCoin = 0;
        int[] left = distribute(root.left);
        int[] right = distribute(root.right);
        extraCoin = left[1] + right[1] + root.val - 1;
        move = left[0] + right[0] + Math.abs(extraCoin);
        return new int[]{move, extraCoin};
    }
}
