import java.util.Map;

class Solution {
    public int[] processQueries(int[] queries, int m) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(i + 1, i);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            res[i] = map.get(query);
            for (int key: map.keySet()) {
                if (map.get(key) < map.get(query)) {
                    map.put(key, map.get(key) + 1);
                }
            }
            map.put(query, 0);
        }
        return res;
    }
}

// Runtime: 125 ms, faster than 13.52% of Java online submissions for Queries on a Permutation With Key.
// Memory Usage: 40.2 MB, less than 100.00% of Java online submissions for Queries on a Permutation With Key.