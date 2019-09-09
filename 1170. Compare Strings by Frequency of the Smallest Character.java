class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] queriesArr = new int[queries.length];
        int[] wordsArr = new int[words.length];
        for (int i = 0; i < queriesArr.length; i++){
        	queriesArr[i] = convert(queries[i]);
        }
        for (int i = 0; i < wordsArr.length; i++){
        	wordsArr[i] = convert(words[i]);
        }
        int[] res = new int[queriesArr.length];
        for (int i = 0; i < res.length; i++){
        	int count = 0;
        	for (int j = 0; j < wordsArr.length; j++){
        		if (wordsArr[j] > queriesArr[i]) count++;
        	}
        	res[i] = count;
        }
        return res;
    }

    int convert(String s){
    	int[] chArr = new int[26];
    	for (char ch: s.toCharArray()){
    		chArr[ch - 'a']++;
    	}
    	for (int i: chArr){
    		if (i != 0) return i;
    	}
    	return 0;
    }
}

//ACC