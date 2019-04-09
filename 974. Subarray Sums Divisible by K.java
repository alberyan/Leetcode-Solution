class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int res = 0;
        A[0] = (A[0] % K + K) % K;
        for (int i = 1; i < A.length; i++){
            A[i] = ((A[i - 1] + A[i]) % K + K) % K;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++){
            if ((A[i] % K) == 0) res++;
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        for (Integer key: map.keySet()){
            int count = map.get(key);
            res += count * (count - 1) / 2;
        }
        return res;
    }
}

// Runtime: 26 ms, faster than 53.65% of Java online submissions for Subarray Sums Divisible by K.
// Memory Usage: 41.4 MB, less than 75.63% of Java online submissions for Subarray Sums Divisible by K.
