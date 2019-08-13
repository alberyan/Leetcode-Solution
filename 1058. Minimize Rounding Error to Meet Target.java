class Solution {
    public String minimizeError(String[] prices, int target) {
    	double res = 0;
    	int len = prices.length;
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int flooring = 0;
        int ceiling = 0;
        for (String price: prices){
        	double cur = Double.parseDouble(price);
        	int floor = (int)cur;
        	flooring += floor;
        	ceiling += floor;
        	maxHeap.offer(cur - floor);
        	if (cur - floor != 0) ceiling++;
        }
        if (target < flooring || target > ceiling) return "-1";
        for (int i = 0; i < target - flooring; i++){
        	res += 1 - maxHeap.poll();
        }
        while (!maxHeap.isEmpty()) res += maxHeap.poll();
        return String.format ("%.3f", res);
    }
}

// Runtime: 7 ms, faster than 82.05% of Java online submissions for Minimize Rounding Error to Meet Target.
// Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for Minimize Rounding Error to Meet Target.