class Solution {
    public int findSpecialInteger(int[] arr) {
        int len = arr.length;
        int count = 1;
        int cur = arr[0];
        if (len == 1) return cur;
        for (int i = 1; i < len; i++){
            if (arr[i] == cur){
                count++;
                if (count > len / 4) return cur; 
            }
            else {
                cur = arr[i];
                count = 1;
            }
        }
        return -1;
    }
}

//ACC