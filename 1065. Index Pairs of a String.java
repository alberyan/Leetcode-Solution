class Solution {
    public int[][] indexPairs(String text, String[] words) {
        List<Integer[]> list = new ArrayList<>();
        for (String word: words){
        	int firstIndex = 0;
        	while (text.indexOf(word, firstIndex) != -1){
        		int start = text.indexOf(word, firstIndex);
        		Integer[] arr = {start, start + word.length() - 1};
        		list.add(arr);
        		firstIndex = start + 1;
        	}
        }
        Collections.sort(list, new Comparator<Integer[]>(){
        	@Override
        	public int compare(Integer[] p1, Integer[] p2){
        		if (p1[0] == p2[0]) return p1[1] - p2[1];
        		return p1[0] - p2[0];
        	}
        });
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++){
        	res[i] = new int[]{list.get(i)[0], list.get(i)[1]};
        }
        return res;
    }
}

// Runtime: 2 ms, faster than 96.89% of Java online submissions for Index Pairs of a String.
// Memory Usage: 36.4 MB, less than 50.00% of Java online submissions for Index Pairs of a String.