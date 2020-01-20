class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        int len = groupSizes.length;
        if (len == 0) {
            return res;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++){
            int size = groupSizes[i];
            List<Integer> cur = map.getOrDefault(size, new ArrayList<>());
            cur.add(i);
            if (cur.size() == size){
                res.add(cur);
                cur = new ArrayList<>();
            }
            map.put(size, cur);
        }
        return res;
    }
}

//ACC