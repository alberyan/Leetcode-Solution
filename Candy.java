class Solution {
    public int candy(int[] ratings) {
    	int len = ratings.length;
        int left = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++){
        	if (min < ratings[i]){
        		left = i;
        		min = ratings;
        	}
        }
        int right = left + 1;
        while (left >= 0){
        	
        }
    }
}