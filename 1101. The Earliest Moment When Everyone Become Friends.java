class Solution {
    public int earliestAcq(int[][] logs, int N) {
        Arrays.sort(logs, (l1, l2) -> l1[0] - l2[0]);
        int count = 0;
       	int[] arr = new int[N];
       	for (int i = 0; i < N; i++){
       		arr[i] = i;
       	}
       	for (int[] log: logs){
       		int time = log[0];
       		int personA = log[1];
       		int personB = log[2];
       		int rootA = arr[personA];
       		int rootB = arr[personB];
       		if (rootA == rootB) continue;
       		if (rootA < rootB){
       			for (int i = 0; i < N; i++){
	       			if (arr[i] == rootB){
	       				arr[i] = rootA;
	       				if (rootA == 0) count++;
	       			}
       			}
       		} else {
       			for (int i = 0; i < N; i++){
	       			if (arr[i] == rootA){
	       				arr[i] = rootB;
	       				if (rootB == 0) count++;
	       			}
       			}
       		}
       		
       		if (count == N - 1) return time;
       	}
       	return -1;
    }
}

// Runtime: 38 ms, faster than 33.24% of Java online submissions for The Earliest Moment When Everyone Become Friends.
// Memory Usage: 44.9 MB, less than 50.00% of Java online submissions for The Earliest Moment When Everyone Become Friends.