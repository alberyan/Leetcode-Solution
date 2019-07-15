class Solution {
    public boolean validUtf8(int[] data) {
    	int len = data.length;
        String[] byteData = new String[len];
        for (int i = 0; i < len; i++){
        	byteData[i] = transform(data[i]);
        }
        return scan(byteData, 0);
    }

    String transform(int num){
    	StringBuilder sb = new StringBuilder();
    	while (sb.length() != 8){
    		sb.append(num % 2);
    		num /= 2;
    	}
    	return sb.reverse().toString();
    }

    boolean scan(String[] byteData, int startIndex){
    	if (startIndex == byteData.length) return true;
    	if (byteData[startIndex].startsWith("0")) return scan(byteData, startIndex + 1);
    	if (byteData[startIndex].startsWith("110")) {
    		if (startIndex + 1 >= byteData.length) return false;
    		if (byteData[startIndex + 1].startsWith("10")) return scan(byteData, startIndex + 2);
    		return false;
    	}
    	if (byteData[startIndex].startsWith("1110")) {
    		if (startIndex + 2 >= byteData.length) return false;
    		for (int i = 1; i <= 2; i++){
    			if (!byteData[startIndex + i].startsWith("10")) return false;
    		}
    		return scan(byteData, startIndex + 3);
    	}
    	if (byteData[startIndex].startsWith("11110")) {
    		if (startIndex + 3 >= byteData.length) return false;
    		for (int i = 1; i <= 3; i++){
    			if (!byteData[startIndex + i].startsWith("10")) return false;
    		}
    		return scan(byteData, startIndex + 4);
    	}
    	return false;
    }
}

// Runtime: 8 ms, faster than 15.10% of Java online submissions for UTF-8 Validation.
// Memory Usage: 39.2 MB, less than 55.32% of Java online submissions for UTF-8 Validation.