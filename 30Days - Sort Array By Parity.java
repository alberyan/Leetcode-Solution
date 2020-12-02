class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int left = 0;
        int right = A.length - 1;
        for (int a: A) {
            if (a % 2 == 0) {
                res[left++] = a;
            } else {
                res[right--] = a;
            }
        }
        return res;
    }
}

// ACC