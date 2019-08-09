class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
    	if (s == null || s.length() == 0) return 0;
    	int res = 0;
    	int i = 0;
    	int j = 0;
    	Map<Character, Integer> map = new HashMap<>();
    	while (j < s.length()){
    		map.put(s.charAt(j), j++);
    		while (map.size() > 2){
    			int first = s.length();
    			char charToDelete = '0';
    			for (Character ch: map.keySet()){
    				if (map.get(ch) < first){
    					charToDelete = ch;
    					first = map.get(ch);
    				}
    			}
    			i = first + 1;
    			map.remove(charToDelete);
    		}
    		res = Math.max(res, j - i);
    	}
    	return res;
    }
}

//ACC