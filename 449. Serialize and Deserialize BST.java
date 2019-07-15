/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public StringBuilder postorder(TreeNode root, StringBuilder sb) {
	    if (root == null) return sb;
	    postorder(root.left, sb);
	    postorder(root.right, sb);
	    sb.append(root.val);
	    sb.append(" ");
	    return sb;
	  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) return "";
    StringBuilder sb = postorder(root, new StringBuilder());
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

  public TreeNode helper(Integer lower, Integer upper, ArrayDeque<Integer> nums) {
    if (nums.isEmpty()) return null;
    int val = nums.getLast();
    if (val < lower || val > upper) return null;

    nums.removeLast();
    TreeNode root = new TreeNode(val);
    root.right = helper(val, upper, nums);
    root.left = helper(lower, val, nums);
    return root;
  }

   public TreeNode deserialize(String data) {
    if (data.isEmpty()) return null;
    ArrayDeque<Integer> nums = new ArrayDeque<Integer>();
    for (String s : data.split("\\s+"))
      nums.add(Integer.valueOf(s));
    return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

// Runtime: 17 ms, faster than 14.27% of Java online submissions for Serialize and Deserialize BST.
// Memory Usage: 38.5 MB, less than 99.59% of Java online submissions for Serialize and Deserialize BST.