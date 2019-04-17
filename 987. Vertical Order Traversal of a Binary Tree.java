/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import javafx.util.Pair;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()){
            Queue<Pair<TreeNode, Integer>> nextQ = new LinkedList<>();
            Map<Integer, List<Integer>> tempMap = new HashMap<>();
            while (!q.isEmpty()){
                Pair<TreeNode, Integer> pair = q.poll();
                TreeNode curNode = pair.getKey();
                int x = pair.getValue();
                List<Integer> tempList = tempMap.getOrDefault(x, new ArrayList<>());
                tempList.add(curNode.val);
                tempMap.put(x, tempList);
                if (curNode.left != null){
                    nextQ.offer(new Pair(curNode.left, x - 1));
                }
                if (curNode.right != null){
                    nextQ.offer(new Pair(curNode.right, x + 1));
                }
            }
            q = nextQ;
            for (Integer x: tempMap.keySet()){
                List<Integer> originList = map.getOrDefault(x, new ArrayList<>());
                List<Integer> tempList = tempMap.get(x);
                Collections.sort(tempList);
                for (Integer val: tempList){
                    originList.add(val);
                }
                map.put(x, originList);
            }
        }
        for (Integer x: map.keySet()){
            list.add(map.get(x));
        }
        return list;
    }
}


// Runtime: 7 ms, faster than 42.01% of Java online submissions for Vertical Order Traversal of a Binary Tree.
// Memory Usage: 38.4 MB, less than 5.07% of Java online submissions for Vertical Order Traversal of a Binary Tree.
