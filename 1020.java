class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int len = A.length;
        int[] res = new int[len];
        res[0] = A[0];
        for (int i = 1; i < len; i++){
          res[i] = res[i - 1] + A[i];
        }
        if (res[len - 1] % 3 != 0){
          return false;
        }
        for (int i = 0; i < len; i++){
          if (res[i] == res[len - 1] / 3){
            for (int j = i + 1; j < len; j++){
              if (res[j] == res[len - 1] / 3 * 2){
                return true;
              }
            }
          }
        }
        return false;
    }
}
