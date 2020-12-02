class SubrectangleQueries {
    class Node {
        int row1;
        int col1;
        int row2;
        int col2;
        int value;
        
        public Node(int row1, int col1, int row2, int col2, int newValue) {
            this.row1 = row1;
            this.col1 = col1;
            this.row2 = row2;
            this.col2 = col2;
            this.value = newValue;
        }
    }
    
    int[][] rectangle;
    List<Node> list;

    public SubrectangleQueries(int[][] rectangle) {
        list = new ArrayList<>();
        this.rectangle = rectangle;
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        list.add(new Node(row1, col1, row2, col2, newValue));
    }
    
    public int getValue(int row, int col) {
        for (int i = list.size() - 1; i >= 0; i--) {
            Node cur = list.get(i);
            if (row >= cur.row1 && row <= cur.row2 && col >= cur.col1 && col <= cur.col2) {
                return cur.value;
            }
        }
        return rectangle[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */