class Solution {
    public int longestArithSeqLength(int[] A) {
        int len = A.length;
        int res = 0;
        if (len <= 2) return len;
        Map<Integer, Integer>[] diffMaps = new HashMap[len];
        diffMaps[0] = new HashMap<>();
        for (int i = 1; i < len; i++){
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < i; j++){
                int diff = A[i] - A[j];
                int acc = map.getOrDefault(diff, 2);
                acc = Math.max(diffMaps[j].getOrDefault(diff, 1) + 1, acc);
                map.put(diff, acc);
                res = Math.max(res, acc);
            }
            diffMaps[i] = map;
        }
        return res;
    }
}
