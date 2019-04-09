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
     public List<TreeNode> allPossibleFBT(int N) {
         List<TreeNode>[] dp = new List[N + 1];
         for (int i = 0; i <= N; i++){
             dp[i] = new ArrayList<>();
         }
         if (N >= 1){
             dp[1].add(new TreeNode(0));
         }
         for (int i = 3; i <= N; i += 2){
             for (int leftCount = 1; leftCount < i; leftCount+= 2){
                 int rightCount = i - 1 - leftCount;
                 for (TreeNode leftNode: dp[leftCount]){
                     for (TreeNode rightNode: dp[rightCount]){
                         TreeNode curNode = new TreeNode(0);
                         curNode.left = leftNode;
                         curNode.right = rightNode;
                         dp[i].add(curNode);
                     }
                 }
             }
         }
         return dp[N];
     }
 }

//  Runtime: 3 ms, faster than 87.52% of Java online submissions for All Possible Full Binary Trees.
// Memory Usage: 44.7 MB, less than 62.73% of Java online submissions for All Possible Full Binary Trees.
