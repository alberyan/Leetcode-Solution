class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new LinkedList<>();
        int len = A.length;
        for (int i = len - 1; i >= 0; i--) {
            int maxIndex = findMax(A, i);
            if (maxIndex == i) {
                continue;
            } else if (maxIndex == 0) {
                res.add(i + 1);
                flip(A, i);
            } else {
                res.add(maxIndex + 1);
                flip(A, maxIndex);
                res.add(i + 1);
                flip(A, i);
            }
        }
        return res;
    }
    
    private int findMax(int[] A, int lastIndex) {
        int index = 0;
        int max = A[0];
        for (int i = 1; i <= lastIndex; i++) {
            if (A[i] > max) {
                index = i;
                max = A[i];
            }
        }
        return index;
    }
    
    private void flip(int[] A, int lastIndex) {
        int left = 0;
        int right = lastIndex;
        while (left < right) {
            int tmp = A[left];
            A[left] = A[right];
            A[right] = tmp;
            left++;
            right--;
        }
    }
}

// ACC