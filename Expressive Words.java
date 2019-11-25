class Solution {
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for (String word: words){
        	if (isExpressive(S, word)) res++;
        }
        return res;
    }

    boolean isExpressive(String S, String word){
    	int indexS = 0;
    	int indexW = 0;
    	while (true){
    		if (indexS == S.length() && indexW == word.length()) return true;
    		if (indexS >= S.length() || indexW >= word.length()) return false;
    		if (S.charAt(indexS) != word.charAt(indexW)) return false;
    		char chS = S.charAt(indexS);
    		char chW = word.charAt(indexW);
    		int startS = indexS;
    		int startW = indexW;
    		while (indexS < S.length() && S.charAt(indexS) == chS) indexS++;
    		while (indexW < word.length() && word.charAt(indexW) == chW) indexW++;
    		int lengthS = indexS - startS;
    		int lengthW = indexW - startW;
    		if (lengthS == lengthW) continue;
    		else if (lengthW > lengthS) return false;
    		else {
    			if (lengthS < 3) return false;
    		}
    	}
    }
}

//ACC