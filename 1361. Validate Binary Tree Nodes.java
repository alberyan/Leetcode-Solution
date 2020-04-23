class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] node = new boolean[n];
        for (int i = 0; i < n; i++) {
            int left = leftChild[i];
            int right = rightChild[i];
            if (left != -1) {
                if (node[left]) return false;
                node[left] = true;
            }
            if (right != -1) {
                if (node[right]) return false;
                node[right] = true;
            }
        }
        int rootCount = 0;
        for (int i = 0; i < n; i++) {
            if (!node[i]) rootCount++;
        }
        return rootCount == 1;
    }
}

// Runtime: 1 ms, faster than 99.77% of Java online submissions for Validate Binary Tree Nodes.
// Memory Usage: 42.5 MB, less than 100.00% of Java online submissions for Validate Binary Tree Nodes.