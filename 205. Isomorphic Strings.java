class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] map = new int[256];
        int[] reverseMap = new int[256];
        Arrays.fill(map, -1);
        Arrays.fill(reverseMap, -1);
        for (int i = 0; i < s.length(); i++){
        	int chS = (int)s.charAt(i);
        	int chT = (int)t.charAt(i);
        	if (map[chS] == chT && reverseMap[chT] == chS) continue;
        	if (map[chS] == -1){
        		if (reverseMap[chT] == -1){
        			map[chS] = chT;
        			reverseMap[chT] = chS;
        			continue;
        		} else return false;
        	}
        	return false;
        }
        return true;
    }
}

// Runtime: 3 ms, faster than 95.98% of Java online submissions for Isomorphic Strings.
// Memory Usage: 36 MB, less than 100.00% of Java online submissions for Isomorphic Strings.