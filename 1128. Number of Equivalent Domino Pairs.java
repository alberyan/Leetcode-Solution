class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] domino: dominoes){
            int i = Math.min(domino[0], domino[1]);
            int j = Math.max(domino[0], domino[1]);
            int cur = i * 10 + j;
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        for (Integer cur: map.keySet()){
            int count = map.get(cur);
            res += count * (count - 1) / 2;
        }
        return res;
    }
}

// Runtime: 9 ms, faster than 100.00% of Java online submissions for Number of Equivalent Domino Pairs.
// Memory Usage: 56.2 MB, less than 100.00% of Java online submissions for Number of Equivalent Domino Pairs.