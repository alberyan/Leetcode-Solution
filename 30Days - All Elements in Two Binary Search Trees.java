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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        helper(list1, root1);
        helper(list2, root2);
        int index1 = 0;
        int index2 = 0;
        while (index1 < list1.size() || index2 < list2.size()) {
            if (index1 >= list1.size()) {
                res.add(list2.get(index2++));
            } else if (index2 >= list2.size()) {
                res.add(list1.get(index1++));
            } else if (list1.get(index1) <= list2.get(index2)) {
                res.add(list1.get(index1++));
            } else {
                res.add(list2.get(index2++));
            }
        }
        return res;
    }

    private void helper(List<Integer> list, TreeNode root){
        if (root == null) return;
        helper(list, root.left);
        list.add(root.val);
        helper(list, root.right);
    }
}

// ACC