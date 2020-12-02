class StreamChecker {
    Node root;
    Queue<Node> q;

    class Node {
        Node[] children;
        boolean isLeaf;

        Node(){
            this.children = new Node[26];
            this.isLeaf = false;
        }
    }

    public StreamChecker(String[] words) {
        root = new Node();
        for (String word: words){
            Node cur = root;
            for (char ch: word.toCharArray()){
                int index = ch - 'a';
                if (cur.children[index] == null){
                    cur.children[index] = new Node();
                }
                cur = cur.children[index];
            }
            cur.isLeaf = true;
        }
        q = new LinkedList<>();
    }

    public boolean query(char letter) {
        int index = letter - 'a';
        boolean res = false;
        Node newRoot = root;
        q.offer(newRoot);
        int loop = q.size();
        for (int i = 0; i < loop; i++){
            Node curNode = q.poll();
            if (curNode.children[index] != null){
                curNode = curNode.children[index];
                res |= curNode.isLeaf;
                q.offer(curNode);
            }
        }
        return res;
    }
}

// ACC