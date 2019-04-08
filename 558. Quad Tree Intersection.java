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
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf && quadTree2.isLeaf){
            return new Node(quadTree1.val || quadTree2.val, true, null, null, null);
        }
        if (quadTree1.isLeaf){
            if (quadTree1.val){
                return quadTree1;
            } else {
                return quadTree2;
            }
        }
        if (quadTree2.isLeaf){
            if (quadTree2.val){
                return quadTree2;
            } else {
                return quadTree1;
            }
        }
        Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

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

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Quad Tree Intersection.
// Memory Usage: 46.5 MB, less than 7.69% of Java online submissions for Quad Tree Intersection.
