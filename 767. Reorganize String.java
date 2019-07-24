class Solution {
	class Node {
		char ch;
		int count;
		public Node(char ch, int count){
			this.ch = ch;
			this.count = count;
		}
	}

    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: S.toCharArray()){
        	map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> (n2.count - n1.count));
        for (char ch: map.keySet()){
        	pq.offer(new Node(ch, map.get(ch)));
        }
        if (pq.peek().count > (S.length() + 1) / 2) return "";
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
        	Node cur = pq.poll();
        	char lastCh = sb.length() > 0 ? sb.charAt(sb.length() - 1): '1';
        	if (cur.ch != lastCh){
        		sb.append(cur.ch);
	        	if (cur.count > 1){
	        		pq.offer(new Node(cur.ch, cur.count - 1));
	        	}
        	} else {
        		Node secondLarge = pq.poll();
        		sb.append(secondLarge.ch);
	        	if (secondLarge.count > 1){
	        		pq.offer(new Node(secondLarge.ch, secondLarge.count - 1));
	        	}
	        	pq.offer(cur);
        	}
        }
        return sb.toString();
    }
}

// Runtime: 35 ms, faster than 29.95% of Java online submissions for Reorganize String.
// Memory Usage: 35.9 MB, less than 80.65% of Java online submissions for Reorganize String.