class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        int[] wordMasks = new int[words.length];
        for (int i = 0; i < words.length; i++){
        	wordMasks[i] = wordToMask(words[i]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < puzzles.length; i++){
        	int count = 0;
        	char ch = puzzles[i].charAt(0);
        	int puzzleMask = wordToMask(puzzles[i]);
        	for (int wordMask: wordMasks){
        		if ((wordMask & 1 << (ch - 'a')) > 0 && (wordMask | puzzleMask) == puzzleMask) count++;
        	}
        	res.add(count);
        }
        return res;
    }

    int wordToMask(String word){
    	int res = 0;
    	for (char ch: word.toCharArray()){
    		res |= 1 << (ch - 'a');
    	}
    	return res;
    }
}

// TLE