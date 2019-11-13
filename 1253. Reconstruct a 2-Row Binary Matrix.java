class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
    	int len = colsum.length;
    	int[] row1 = new int[len];
    	int[] row2 = new int[len];
    	int count = 0;
    	for (int i = 0; i < len; i++){
    		if (colsum[i] == 2) {
    			row1[i] = 1;
    			row2[i] = 1;
    			upper--;
    			lower--;
    		} else if (colsum[i] == 1){
    			count++;
    		}
    	}
    	List<List<Integer>> res = new ArrayList<>();
    	if (upper < 0 || lower < 0 || count != upper + lower) return res;
    	int index = 0;
    	while (upper + lower > 0){
    		while (upper > 0){
    			if (colsum[index] == 1){
    				row1[index] = 1;
    				upper--;
    			}
    			index++;
    		}
    		while (lower > 0){
    			if (colsum[index] == 1){
    				row2[index] = 1;
    				lower--;
    			}
    			index++;
    		}
    	}
        List<Integer> list1 = new ArrayList<>();
        for (int i: row1){
        	list1.add(i);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int i: row2){
        	list2.add(i);
        }
        res.add(list1);
        res.add(list2);
        return res;
    }
}

//ACC