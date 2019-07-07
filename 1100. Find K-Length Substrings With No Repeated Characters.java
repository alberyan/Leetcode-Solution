class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        int len = S.length();
        if (K > len){
        	return 0;
        }
        int arrLen = len - K + 1;
        boolean[] arr = new boolean[arrLen];
        Arrays.fill(arr, true);
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++){
        	char ch = S.charAt(i);
        	List<Integer> list = map.getOrDefault(ch, new ArrayList<>());
        	list.add(i);
        	map.put(ch, list);
        }
        for (char ch: map.keySet()){
        	List<Integer> list = map.get(ch);
        	if (list.size() == 1) continue;
        	for (int i = 0; i < list.size() - 1; i++){
        		int index1 = list.get(i);
        		int index2 = list.get(i + 1);
        		if (index2 - index1 < K){
        			for (int j = index2 - K + 1; j <= index1 && j < arrLen; j++){
        				if (j >= 0) arr[j] = false;
        			}
        		}
        	}
        }
        int res = 0;
        for (boolean b: arr){
        	res += b ? 1 : 0;
        }
        return res;
    }
}

// Runtime: 68 ms, faster than 5.06% of Java online submissions for Find K-Length Substrings With No Repeated Characters.
// Memory Usage: 37.5 MB, less than 50.00% of Java online submissions for Find K-Length Substrings With No Repeated Characters.