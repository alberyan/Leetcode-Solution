class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        if (A.length != B.length) return -1;
        List<Integer>[] listA = new ArrayList[7];
        List<Integer>[] listB = new ArrayList[7];
        for (int i = 1; i <= 6; i++){
            listA[i] = new ArrayList<Integer>();
            listB[i] = new ArrayList<Integer>();
        }
        int[] count = new int[7];
        for (int i = 0; i < A.length; i++){
            int a = A[i];
            int b = B[i];
            listA[a].add(i);
            listB[b].add(i);
            count[a]++;
            count[b]++;
            if (a==b) count[a]--;
        }
        int res = -1;
        for (int i = 1; i <= 6; i++){
          if (count[i] == A.length){
            res = Math.max(res, A.length - Math.max(listA[i].size(), listB[i].size()));
          }
        }
        return res;
    }
}
