class Solution {
    public boolean isIdealPermutation(int[] A) {
        int global = 0, local = 0, len = A.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (A[i] > A[j]) global++;
            }
            if (A[i] > A[i + 1]) local++;
        }
        return global == local;
    }
}