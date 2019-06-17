class Node {
	int value;
	int label;
	public Node(int value, int label){
		this.value = value;
		this.label = label;
	}
}
class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        Map<Integer, Integer> visited = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((Node n1, Node n2) -> n2.value - n1.value);
        for (int i = 0; i < values.length; i++){
        	pq.offer(new Node(values[i], labels[i]));
        }
        int sum = 0;
        int count = 0;
        while (count < num_wanted && !pq.isEmpty()){
        	Node node = pq.poll();
        	int num = visited.getOrDefault(node.label, 0);
        	if (num >= use_limit) continue;
        	count++;
        	sum += node.value;
        	visited.put(node.label, num + 1);
        }
        return sum;
    }
}

// Runtime: 60 ms, faster than 15.94% of Java online submissions for Largest Values From Labels.
// Memory Usage: 40.7 MB, less than 100.00% of Java online submissions for Largest Values From Labels.