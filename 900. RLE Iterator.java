class RLEIterator {
    int index;
    int[] A;
    public RLEIterator(int[] A) {
        this.A = A;
        index = 0;
    }

    public int next(int n) {
        int res = -1;
        while (n > 0 && index < A.length){
            int count = Math.max(0, A[index] - n);
            n = Math.max(0, n - A[index]);
            A[index] = count;
            if (n == 0){
                res = A[index + 1];
            }
            if (count == 0){
                index += 2;
            }
        }
        return res;
    }
}

// Runtime: 50 ms, faster than 64.63% of Java online submissions for RLE Iterator.
// Memory Usage: 42.7 MB, less than 5.88% of Java online submissions for RLE Iterator.


/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */
