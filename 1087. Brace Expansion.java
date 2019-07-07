class Solution {
    public String[] expand(String S) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(S, 0, sb, list);
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++){
        	res[i] = list.get(i);
        }
        Arrays.sort(res);
        return res;
    }

    private void dfs(String S, int index, StringBuilder sb, List<String> list) {
    	if (index == S.length()){
    		list.add(sb.toString());
    		return;
    	}
    	char ch = S.charAt(index);
    	if (ch == '{') {
    		index++;
    		List<Character> charList = new ArrayList<>();
    		while (index < S.length()){
    			ch = S.charAt(index++);
    			if (ch <= 'z' && ch >= 'a'){
    				charList.add(ch);
    			}
    			if (ch == '}') break;
    		}
    		for (char c: charList){
    			sb.append(c);
    			dfs(S, index, sb, list);
    			sb.setLength(sb.length() - 1);
    		}
    	} else {
    		sb.append(ch);
    		dfs(S, index + 1, sb, list);
    		sb.setLength(sb.length() - 1);
    	}
    }
}

// Runtime: 2 ms, faster than 99.06% of Java online submissions for Brace Expansion.
// Memory Usage: 37.6 MB, less than 100.00% of Java online submissions for Brace Expansion.