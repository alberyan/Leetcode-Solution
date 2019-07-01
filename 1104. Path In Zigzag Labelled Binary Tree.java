class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = 1;
        while (n * 2 <= label){
        	n *= 2;
        }
        while (label > 0){
        	stack.offerFirst(label);
        	int tmp = label / 2;
        	n = n / 2;
        	label = 3 * n - 1 - tmp;
        }
        List<Integer> list = new LinkedList<>();
        while (!stack.isEmpty()){
        	list.add(stack.pollFirst());
        }
        return list;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Path In Zigzag Labelled Binary Tree.
// Memory Usage: 33.4 MB, less than 100.00% of Java online submissions for Path In Zigzag Labelled Binary Tree.