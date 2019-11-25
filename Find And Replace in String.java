class Solution {
	class Node{
		int index;
        String source;
        String target;
        Node(int index, String source, String target){
        	this.index = index;
        	this.source = source;
        	this.target = target;
        }
	}

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int diff = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.index - n2.index);
        for (int i = 0; i < indexes.length; i++){
        	pq.offer(new Node(indexes[i], sources[i], targets[i]));
        }
        while (!pq.isEmpty()){
        	Node cur = pq.poll();
        	int index = cur.index + diff;
        	String source = cur.source;
        	String target = cur.target;
        	if (index == 0){
        		int tmp = S.indexOf(source);
        		if (tmp == 0){
        			S = target + S.substring(source.length());
        			diff += target.length() - source.length();
        		}
        	} else {
        		int tmp = S.indexOf(source, index);
        		if (tmp == index){
        			S = S.substring(0, index) + target + S.substring(index + source.length());
        			diff += target.length() - source.length();
        		}
        	}
        }
        return S;
    }
}

//ACC