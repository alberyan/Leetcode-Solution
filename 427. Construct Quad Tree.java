/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node construct(int[][] grid) {
        int len = grid.length;
        return construct(grid, 0, len - 1, 0, len - 1);
    }

    Node construct(int[][] grid, int startX, int endX, int startY, int endY){
        if (endX == startX){
            boolean val = (grid[startX][startY] == 1);
            return new Node(val, true, null, null, null, null);
        }
        int midX = (startX + endX - 1) / 2;
        int midY = (startY + endY - 1) / 2;
        Node topLeft = construct(grid, startX, midX, startY, midY);
        Node bottomLeft = construct(grid, midX + 1, endX, startY, midY);
        Node topRight = construct(grid, startX, midX, midY + 1, endY);
        Node bottomRight = construct(grid, midX + 1, endX, midY + 1, endY);

        boolean isAllLeaf = topLeft.isLeaf && bottomLeft.isLeaf && topRight.isLeaf && bottomRight.isLeaf;
        if (!isAllLeaf) return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);

        boolean isAllValueTrue = topLeft.val && bottomLeft.val && topRight.val && bottomRight.val;
        if (isAllValueTrue){
            return new Node(true, true, null, null, null, null);
        }
        boolean isAllValueFalse = topLeft.val || bottomLeft.val || topRight.val || bottomRight.val;
        if (!isAllValueFalse) return new Node(false, true, null, null, null, null);

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Construct Quad Tree.
// Memory Usage: 42.5 MB, less than 58.62% of Java online submissions for Construct Quad Tree.
