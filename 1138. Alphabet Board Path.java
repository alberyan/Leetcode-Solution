class Solution {
    public String alphabetBoardPath(String target) {
       	StringBuilder sb = new StringBuilder();
       	char start = 'a';
       	for (char ch: target.toCharArray()){
       		sb.append(path(start, ch));
       		start = ch;
       	}
       	return sb.toString();
    }

    private String path(char start, char end){
    	StringBuilder sb = new StringBuilder();
    	int startX = (start - 'a') / 5;
    	int startY = (start - 'a') % 5;
    	int endX = (end - 'a') / 5;
    	int endY = (end - 'a') % 5;
    	if (startX <= endX && startY <= endY){
    		for (int i = startX + 1; i <= endX; i++){
    			sb.append('D');
    		}
    		for (int i = startY + 1; i <= endY; i++){
    			sb.append('R');
    		}
    	} else if (startX >= endX && startY <= endY){
    		for (int i = startX - 1; i >= endX; i--){
    			sb.append('U');
    		}
    		for (int i = startY + 1; i <= endY; i++){
    			sb.append('R');
    		}
    	} else if (startX <= endX && startY >= endY){
    		for (int i = startY - 1; i >= endY; i--){
    			sb.append('L');
    		}
    		for (int i = startX + 1; i <= endX; i++){
    			sb.append('D');
    		}
    	} else if (startX >= endX && startY >= endY){
    		for (int i = startY - 1; i >= endY; i--){
    			sb.append('L');
    		}
    		for (int i = startX - 1; i >= endX; i--){
    			sb.append('U');
    		}
    	}
    	sb.append('!');
        return sb.toString();
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Alphabet Board Path.
// Memory Usage: 34.8 MB, less than 100.00% of Java online submissions for Alphabet Board Path.