class Solution {
    public int maxNumberOfApples(int[] arr) {
        int cur = 0;
        int res = 0;
        Arrays.sort(arr);
        for (int i: arr){
        	if (cur + i <= 5000){
        		cur += i;
        		res++;
        	} else return res;
        }
        return res;
    }
}

//Acc