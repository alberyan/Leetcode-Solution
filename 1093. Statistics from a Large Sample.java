class Solution {
    public double[] sampleStats(int[] count) {
    	int len = count.length;
        double[] res = new double[5];
        for (int i = 0; i < len; i++) {
        	if (count[i] > 0){
        		res[0] = (double)i;
        		break;
        	}
        }
        for (int i = len - 1; i >= 0; i--) {
        	if (count[i] > 0){
        		res[1] = (double)i;
        		break;
        	}
        }
       	int total = 0;
       	double sum = 0;
       	int max = 0;
       	for (int i = 0; i < len; i++){
       		sum += i * count[i];
       		total += count[i];
       		if (count[i] > max){
       			max = count[i];
       			res[4] = (double)i;
       		}
       	}
       	res[2] = sum / total;
       	int acc = 0;
       	if (total % 2 != 0) {
	       	for (int i = 0; i < len; i++){
	       		acc += count[i];
	       		if (acc >= total / 2 + 1){
	       			res[3] = i;
	       			break;
	       		}
	       	}
	    } else {
	    	int tmp = 0;
	    	for (int i = 0; i < len; i++){
	    		if (count[i] == 0) continue;
	    		acc += count[i];
	    		if (acc >= total / 2 + 1){
	    			if (tmp > 0){
	    				res[3] = (tmp + i + 0.0) / 2;
	    			} else {
	    				res[3] = (double)i;
	    			}
	       			break;
	    		} else if (acc == total / 2) {
	    			tmp = i;
	    		}
	       	}
	    }
	    return res;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Statistics from a Large Sample.
// Memory Usage: 38.1 MB, less than 100.00% of Java online submissions for Statistics from a Large Sample.