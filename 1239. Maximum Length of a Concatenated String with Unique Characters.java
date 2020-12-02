class Solution {
    public int maxLength(List<String> arr) {
        List<Set<Integer>> list = new ArrayList<>();
        int res = 0;
        for (int i = 0; i <= 26; i++){
        	list.add(new HashSet<>());
        }
        for (String s: arr){
        	Set<Integer> cur = list.get(s.length());
        	res = Math.max(res, s.length());
        	cur.add(convert(s));
        }
        for (int i = 2; i <= 26; i++){
        	for (int j = 1; j < i; j++){
        		Set<Integer> setA = list.get(j);
        		Set<Integer> setB = list.get(i - j);
        		for (int a: setA){
        			for (int b: setB){
        				if (a & b == 0){
        					list.get(i).add(a | b);
        					res = Math.max(res, i);
        				}
        			}
        		}
        	}
        }
        return res;
    }

    private int convert(String s){
    	int res = 0;
    	for (char ch: s.toCharArray()){
    		res += 1 << (ch - 'a');
    	}
    	return res;
    }
}

