class Solution {
    public int oddEvenJumps(int[] A) {
    	int len = A.length;
        int[] oddNext = new int[len];
        for (int i = 0; i < len; i++){
        	oddNext[i] = i;
        	int minValue = Integer.MAX_VALUE;
        	int minJ = -1;
        	for (int j = i + 1; j < len; j++){
        		if (A[j] >= A[i]){
        			if (A[j] < minValue){
        				minValue = A[j];
        				minJ = j;
        			}
        		}
        	}
        	oddNext[i] = minJ;
        }
        int[] evenNext = new int[len];
        for (int i = 0; i < len; i++){
        	evenNext[i] = i;
        	int maxValue = Integer.MIN_VALUE;
        	int maxJ = -1;
        	for (int j = i + 1; j < len; j++){
        		if (A[j] <= A[i]){
        			if (A[j] > maxValue){
        				maxValue = A[j];
        				maxJ = j;
        			}
        		}
        	}
        	evenNext[i] = maxJ;
        }
        int[] evenSteps = new int[len];
        int[] oddSteps = new int[len];
        for (int i = 0; i < len; i++){
        	evenSteps[i] = 1;
        }

        for (int i = 0; i < len; i++){
        	int curEven = evenSteps[i];
        	if (oddNext[i] != -1){
        		oddSteps[oddNext[i]] += curEven;
        	}
        	int curOdd = oddSteps[i];
        	if (evenNext[i] != -1){
        		evenSteps[evenNext[i]] += curOdd;
        	}
        }
        return evenSteps[len - 1] + oddSteps[len - 1];
    }
}

// TLE

class Solution {
    public int oddEvenJumps(int[] A) {
        int len = A.length;
        int[] oddNext = new int[len];
        int[] evenNext = new int[len];
        Arrays.fill(oddNext, -1);
        Arrays.fill(evenNext, -1);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = len - 1; i >= 0; i--){
            int cur = A[i];
            Integer minGreater = map.ceilingKey(cur);
            if (minGreater != null) oddNext[i] = map.get(minGreater);
            Integer maxLess = map.floorKey(cur);
            if (maxLess != null) evenNext[i] = map.get(maxLess);
            map.put(cur, i);
        }
        int[] evenSteps = new int[len];
        int[] oddSteps = new int[len];
        for (int i = 0; i < len; i++){
            evenSteps[i] = 1;
        }

        for (int i = 0; i < len; i++){
            int curEven = evenSteps[i];
            if (oddNext[i] != -1){
                oddSteps[oddNext[i]] += curEven;
            }
            int curOdd = oddSteps[i];
            if (evenNext[i] != -1){
                evenSteps[evenNext[i]] += curOdd;
            }
        }
        return evenSteps[len - 1] + oddSteps[len - 1];
    }
}

// TreeMap + DP
// ACC