class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Set<String> wordSet = new HashSet<>();
        for (String word: wordList){
        	wordSet.add(word);
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int res = 1;
        while (!q.isEmpty()){
        	res++;
        	int size = q.size();
        	for (int i = 0; i < size; i++){
        		String cur = q.poll();
        		char[] arr = cur.toCharArray();
        		for (int j = 0; j < arr.length; j++){
        			char tmp = arr[j];
        			for (char ch = 'a'; ch <= 'z'; ch++){
        				arr[j] = ch;
        				String newString = new String(arr);
        				if (newString.equals(endWord)) return res;
        				if (wordSet.contains(newString)){
        					q.offer(newString);
        					wordSet.remove(newString);
        				}
        			}
        			arr[j] = tmp;
        		}
        	}
        }
        return 0;
    }
}

// ACC