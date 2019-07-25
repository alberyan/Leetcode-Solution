class Solution {
    public int[] maxDepthAfterSplit(String seq) {
    	if (seq.length() == 0){
    		return new int[0];
    	}
    	int[] res = new int[seq.length()];
    	int maxDepth = 0;
        int count = 0;
        for (char ch: seq.toCharArray()){
        	if (ch == '('){
        		count++;
        		maxDepth = Math.max(maxDepth, count);
        	} else {
        		count--;
        	}
        }
        for (int i = 0; i < seq.length(); i++){
        	char ch = seq.charAt(i);
        	if (ch == '('){
        		count++;
        		if (count > maxDepth / 2){
	        		res[i] = 1;	
	        	}
        	} else {
        		if (count > maxDepth / 2){
	        		res[i] = 1;	
	        	}
        		count--;
        	}
        	
        }
        return res;
    }
}

// O(n)
// Runtime: 2 ms, faster than 45.37% of Java online submissions for Maximum Nesting Depth of Two Valid Parentheses Strings.
// Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Maximum Nesting Depth of Two Valid Parentheses Strings.