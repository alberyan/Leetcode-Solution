class Solution {
    public int findMaxLength(int[] nums) {
        int cur = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        map.put(0, list);
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i] == 0 ? -1 : 1;
            List<Integer> curList = map.getOrDefault(cur, new ArrayList<>());
            curList.add(i);
            map.put(cur, curList);
        }
        int res = 0;
        for (int key: map.keySet()) {
            List<Integer> curList = map.get(key);
            res = Math.max(res, curList.get(curList.size() - 1) - curList.get(0));
        }
        return res;
    }
}

//ACC