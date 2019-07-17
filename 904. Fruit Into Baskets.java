class Solution {
    public int totalFruit(int[] tree) {
    	if (tree.length <= 2) return tree.length;
        int res = 0;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> basket = new HashMap<>();
        while (right < tree.length){
        	int cur = tree[right++];
        	if (basket.containsKey(cur)){
        		basket.put(cur, basket.get(cur) + 1);
        	} else {
        		basket.put(cur, 1);
	        	while (basket.keySet().size() > 2){
	        		int leftTree = tree[left++];
	        		int count = basket.get(leftTree);
	        		if (count == 1){
	        			basket.remove(leftTree);
	        		} else {
	        			basket.put(leftTree, count - 1);
	        		}
	        	}
        	}
        	res = Math.max(res, right - left);
        }
        return res;
    }
}

// Runtime: 49 ms, faster than 46.95% of Java online submissions for Fruit Into Baskets.
// Memory Usage: 49.4 MB, less than 60.81% of Java online submissions for Fruit Into Baskets.