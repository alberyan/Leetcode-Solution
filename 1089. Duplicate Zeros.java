class Solution {
    public void duplicateZeros(int[] arr) {
    	int len = arr.length;
    	Queue<Integer> q = new LinkedList<>();
    	for (int i = 0; i < len; i++){
    		if (!q.isEmpty()){
    			q.offer(arr[i]);
    			arr[i] = q.poll();
    		}
    		if (arr[i] == 0){
    			if (i < len - 1){
    				q.offer(arr[i + 1]);
    				arr[i + 1] = 0;
    				i++;
    			}
    		}
    	}
    }
}

// Runtime: 2 ms, faster than 100.00% of Java online submissions for Duplicate Zeros.
// Memory Usage: 37.5 MB, less than 100.00% of Java online submissions for Duplicate Zeros.