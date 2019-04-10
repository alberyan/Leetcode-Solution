/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class CBTInserter {
    TreeNode root;
    List<TreeNode> list;

    public CBTInserter(TreeNode root) {
        this.root = root;
        list = new ArrayList<>();
        list.add(root);
        int index = 0;
        while (true){
            TreeNode curNode = list.get(index);
            if (curNode.left != null){
                list.add(curNode.left);
            } else break;
            if (curNode.right != null){
                list.add(curNode.right);
            } else {
                break;
            }
            index++;
        }
    }

    public int insert(int v) {
        TreeNode curNode = new TreeNode(v);
        list.add(curNode);
        int index = list.size() - 1;
        TreeNode parent = list.get((index - 1) / 2);
        if (index % 2 == 1){
            parent.left = curNode;
        } else {
            parent.right = curNode;
        }
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
}

// Runtime: 57 ms, faster than 90.78% of Java online submissions for Complete Binary Tree Inserter.
// Memory Usage: 40.2 MB, less than 84.91% of Java online submissions for Complete Binary Tree Inserter.

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */


// A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.
//
// Write a data structure CBTInserter that is initialized with a complete binary tree and supports the following operations:
//
// CBTInserter(TreeNode root) initializes the data structure on a given tree with head node root;
// CBTInserter.insert(int v) will insert a TreeNode into the tree with value node.val = v so that the tree remains complete, and returns the value of the parent of the inserted TreeNode;
// CBTInserter.get_root() will return the head node of the tree.
//
//
// Example 1:
//
// Input: inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
// Output: [null,1,[1,2]]
// Example 2:
//
// Input: inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
// Output: [null,3,4,[1,2,3,4,5,6,7,8]]
