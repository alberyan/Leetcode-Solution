class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
    	int len1 = arr1.length;
    	int len2 = arr2.length;
        int[] temp = new int[Math.max(len1, len2) + 2];
        int index1 = len1 - 1, index2 = len2 - 1, index = temp.length - 1;
        int add = 0;
        while (index1 >= -1 || index2 >= -1 || add != 0){
        	int cur = -add;
        	if (index1 >= 0){
        		cur += arr1[index1];
        	}
        	if (index2 >= 0){
        		cur += arr2[index2];
        	}
        	if (cur == -1) {
        		cur = 1;
        		add = -1;
        	} else {
        		add = cur / 2;
        		cur = cur % 2;
        	}
        	index1--;
        	index2--;
        	temp[index--] = cur;
        }
        index = 0;
        while (temp[index] == 0){
        	index++;
        	if (index == temp.length) return new int[]{0};
        }
        int[] res = new int[temp.length - index];
        for (int i = index; i < temp.length; i++){
        	res[i - index] = temp[i];
        }
        return res;
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Adding Two Negabinary Numbers.
// Memory Usage: 40.7 MB, less than 100.00% of Java online submissions for Adding Two Negabinary Numbers.