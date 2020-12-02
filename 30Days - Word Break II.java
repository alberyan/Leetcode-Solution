class SolutionTLE {
    class Node {
        Node[] children;
        boolean isLeaf;
        public Node() {
            children = new Node[26];
            isLeaf = false;
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        Node root = new Node();
        for (String word: wordDict) {
            addToTrie(root, word, 0);
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, sb, root, root, s, 0);
        return res;
    }
    
    private void addToTrie(Node root, String s, int index) {
        if (index == s.length()) {
            root.isLeaf = true;
            return;
        }
        char ch = s.charAt(index);
        if (root.children[ch - 'a'] == null) {
            root.children[ch - 'a'] = new Node();
        }
        addToTrie(root.children[ch - 'a'], s, index + 1);
    }
    
    private void helper(List<String> res, StringBuilder sb, Node root, Node cur, String s, int index) {
        if (index >= s.length()) {
            return;
        }
        char ch = s.charAt(index);
        if (cur.children[ch - 'a'] == null) return;
        Node next = cur.children[ch - 'a'];
        sb.append(ch);
        if (next.isLeaf) {
            if (index == s.length() - 1) {
                res.add(sb.toString());
            } else {
                sb.append(' ');
                helper(res, sb, root, root, s, index + 1);
                sb.deleteCharAt(sb.length() - 1);
                helper(res, sb, root, next, s, index + 1);
            }
        } else {
            helper(res, sb, root, next, s, index + 1);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}

class SolutionACC {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }       

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s)) return map.get(s);
        
        LinkedList<String>res = new LinkedList<String>();     
        if (s.length() == 0) {
            res.add("");
            return res;
        }               
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) 
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
            }
        }       
        map.put(s, res);
        return res;
    }
}