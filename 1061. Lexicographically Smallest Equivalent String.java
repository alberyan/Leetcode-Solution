class Solution {
    public String smallestEquivalentString(String A, String B, String S) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < A.length(); i++){
        	add(map, A.charAt(i), B.charAt(i));
        }
        Map<Character, Character> eqMap = new HashMap<>();
        boolean[] visited = new boolean[26];
        for (char ch = 'a'; ch <= 'z'; ch++){
        	if (visited[ch - 'a']) continue;
        	Queue<Character> queue = new LinkedList<>();
        	queue.offer(ch);
        	visited[ch - 'a'] = true;
        	while (!queue.isEmpty()){
        		char cur = queue.poll();
        		eqMap.put(cur, ch);
        		Set<Character> set = map.getOrDefault(cur, new HashSet<>());
        		for (char next: set){
        			if (!visited[next - 'a']){
        				queue.offer(next);
        				visited[next - 'a'] = true;
        			}
        		}
        	} 
        }
        StringBuilder sb = new StringBuilder();
        for (char ch: S.toCharArray()){
        	sb.append(eqMap.getOrDefault(ch, ch));
        }
        return sb.toString();
    }

    void add(Map<Character, Set<Character>> map, char a, char b){
    	Set<Character> set = map.getOrDefault(a, new HashSet<>());
    	set.add(b);
    	map.put(a, set);
    	set = map.getOrDefault(b, new HashSet<>());
    	set.add(a);
    	map.put(b, set);
    }
}

// Runtime: 8 ms, faster than 10.17% of Java online submissions for Lexicographically Smallest Equivalent String.
// Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Lexicographically Smallest Equivalent String.

class Solution {
    public String smallestEquivalentString(String A, String B, String S) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);
            int root_a = find(parent, a - 'a');
            int root_b = find(parent, b - 'a');
            if (root_a == root_b) {
                continue;
            }
            if (root_a > root_b) {
                parent[root_a] = root_b;
            } else {
                parent[root_b] = root_a;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < S.length(); i++) {
            char c = (char)('a' + find(parent, S.charAt(i) - 'a'));
            sb.append(c);
        }
        return sb.toString();
    }
    public int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Lexicographically Smallest Equivalent String.
// Memory Usage: 35.7 MB, less than 100.00% of Java online submissions for Lexicographically Smallest Equivalent String.