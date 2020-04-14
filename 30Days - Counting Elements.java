class Solution {
    public int countElements(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a: arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int res = 0;
        for (int a: map.keySet()) {
            if (map.get(a + 1) != null) {
                res += map.get(a);
            }
        }
        return res;
    }
}

//Acc