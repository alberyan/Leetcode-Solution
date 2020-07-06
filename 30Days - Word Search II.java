class SolutionTLE {
    class Node {
        Node[] children;
        public Node() {
            children = new Node[26];
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Node root = new Node();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, i, j, root, visited);
            }
        }

        List<String> res = new LinkedList<>();
        for (String word: words) {
            if (check(root, word)) {
                res.add(word);
            }
        }
        return res;
    }
    
    private void dfs(char[][] board, int i, int j, Node root, boolean[][] visited) {
        visited[i][j] = true;
        char ch = board[i][j];
        if (root.children[ch - 'a'] == null) {
            root.children[ch - 'a'] = new Node();
        }
        Node node = root.children[ch - 'a'];

        int rows = board.length;
        int cols = board[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir: dirs) {
            int newI = i + dir[0], newJ = j + dir[1];
            if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols && !visited[newI][newJ]) {
                dfs(board, newI, newJ, node, visited);
            }
        }
        visited[i][j] = false;
    }

    private boolean check(Node root, String word) {
        Node cur = root;
        for (char ch: word.toCharArray()) {
            if (cur.children[ch - 'a'] == null) return false;
            cur = cur.children[ch - 'a'];
        }
        return true;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }
    
    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }
    
        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res); 
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res); 
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res); 
        board[i][j] = c;
    }
    
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
           }
           p.word = w;
        }
        return root;
    }
    
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}

// ACC