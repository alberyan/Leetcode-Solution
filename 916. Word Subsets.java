class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[][] arrA = new int[A.length][26];

        for (int i = 0; i < A.length; i++){
            for (char ch: A[i].toCharArray()){
                arrA[i][ch - 'a']++;
            }
        }
        int[] arr = new int[26];
        for (int i = 0; i < B.length; i++){
            int[] arrB = new int[26];
            for (char ch: B[i].toCharArray()){
                arrB[ch - 'a']++;
            }
            for (int j = 0; j < 26; j++){
                arr[j] = Math.max(arr[j], arrB[j]);
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < A.length; i++){
            boolean flag = true;
            for (int k = 0; k < 26; k++){
                if (arrA[i][k] < arr[k]){
                    flag = false;
                    break;
                }
            }

            if (flag){
                res.add(A[i]);
            }
        }
        return res;
    }
}

// Runtime: 27 ms, faster than 59.82% of Java online submissions for Word Subsets.
// Memory Usage: 51.6 MB, less than 37.71% of Java online submissions for Word Subsets.
