class Solution {

    class Node {
        int val;
        int depth;
        Node[] children;
        Node parent;
        char ch;

        Node(int val, int depth, char ch){
            this.val = val;
            this.children = new Node[26];
            this.depth = depth;
            this.ch = ch;
        }
    }

    public String longestDupSubstring(String S) {
        Node root = new Node(0, 0, '0');
        int maxDepth = 0;
        Node maxNode = root;
        Queue<Node> q = new LinkedList<>();
        for (char ch: S.toCharArray()){
            int index = ch - 'a';
            Node newRoot = root;
            q.offer(root);
            for (int i = 0; i < q.size(); i++){
                Node cur = q.poll();
                if (cur.children[index] == null){
                    cur.children[index] = new Node(1, cur.depth + 1, ch);
                    cur.children[index].parent = cur;
                } else {
                    cur.children[index].val = cur.children[index].val + 1;
                }
                if (cur.children[index].val >= 2 && cur.children[index].depth > maxDepth){
                    maxDepth = cur.children[index].depth;
                    maxNode = cur.children[index];
                }
                q.offer(cur.children[index]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (maxNode.parent != null){
            sb.append(maxNode.ch);
            maxNode = maxNode.parent;
        }
        return sb.reverse().toString();
    }
}


//TLE
