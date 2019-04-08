class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        sort(A, res, A.length - 1);
        return res;
    }

    void sort(int[] A, List<Integer> res, int last){
        if (last == 0) return;
        int maxIndex = 0;
        int maxVal = A[0];
        for (int i = 0; i <= last; i++){
            if (A[i] > maxVal){
                maxIndex = i;
                maxVal = A[i];
            }
        }
        if (maxIndex == last){
        } else if (maxIndex == 0){
            res.add(last + 1);
            flip(A, 0, last);
        } else {
            res.add(maxIndex + 1);
            res.add(last + 1);
            flip(A, 0, maxIndex);
            flip(A, 0, last);
        }
        sort(A, res, last - 1);
    }

    void flip(int[] A, int a, int b){
        while (a < b){
            int tmp = A[a];
            A[a] = A[b];
            A[b] = tmp;
            a++;
            b--;
        }
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Pancake Sorting.
// Memory Usage: 39.7 MB, less than 7.77% of Java online submissions for Pancake Sorting.
