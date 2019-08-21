class Solution {
    public int minSwaps(int[] data) {
        int oneCount = 0;
        for (int i: data){
            oneCount += i;
        }
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        for (int i = 0; i < oneCount; i++){
            if (data[right++] == 0) zeroCount++;
        }
        int minSwap = zeroCount;
        while (right< data.length){
            if (data[right++] == 0) zeroCount++;
            if (data[left++] == 0) zeroCount--;
            minSwap = Math.min(minSwap, zeroCount);
        }
        return minSwap;
    }
}

// ACC