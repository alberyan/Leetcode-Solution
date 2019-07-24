class MedianFinder {
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
       	minHeap = new PriorityQueue<>();
       	maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
    	if (minHeap.size() == 0 || maxHeap.size() == 0 || num >= minHeap.peek()){
    		minHeap.offer(num);
	        if (minHeap.size() - maxHeap.size() >= 2){
	        	maxHeap.offer(minHeap.poll());
	        }
    	} else {
    		maxHeap.offer(num);
	        if (maxHeap.size() - minHeap.size() >= 2){
	        	minHeap.offer(maxHeap.poll());
	        }
    	}
    }
    
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()){
        	return (minHeap.peek() + maxHeap.peek() + 0.0) / 2;
        } else if (minHeap.size() > maxHeap.size()){
        	return minHeap.peek() + 0.0;
        } else {
        	return maxHeap.peek() + 0.0;
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// Runtime: 165 ms, faster than 9.78% of Java online submissions for Find Median from Data Stream.
// Memory Usage: 66.6 MB, less than 51.14% of Java online submissions for Find Median from Data Stream.