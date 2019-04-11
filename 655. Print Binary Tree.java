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
    public List<List<String>> printTree(TreeNode root) {
        List<List<TreeNode>> list = new ArrayList<>();
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        boolean flag = true;
        while (flag){
            list.add(cur);
            List<TreeNode> next = new ArrayList<>();
            flag = false;
            for (TreeNode node: cur){
                if (node == null){
                    next.add(null);
                    next.add(null);
                } else {
                    next.add(node.left);
                    next.add(node.right);
                    if (node.left != null || node.right != null){
                        flag = true;
                    }
                }
            }
            cur = next;
        }
        int len = list.size();
        int col = 1;
        for (int i = 0; i < len; i++){
            col *= 2;
        }
        col -=1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < len; i++){
            List<String> curStringList = new ArrayList<>();
            for (int j = 0; j < col; j++){
                curStringList.add("");
            }
            res.add(curStringList);
        }
        int mul = 1;
        for (int i = 0; i < len; i++){
            int curLine = len - i - 1;
            List<String> curStringList = res.get(curLine);
            List<TreeNode> curNodeList = list.get(curLine);
            for (int j = 0; j < curNodeList.size(); j++){
                TreeNode curNode = curNodeList.get(j);
                if (curNode == null) continue;
                curStringList.set(mul * 2 * j + mul - 1, curNode.val + "");
            }
            mul *= 2;
        }

        return res;
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Print Binary Tree.
// Memory Usage: 37.4 MB, less than 80.95% of Java online submissions for Print Binary Tree.
