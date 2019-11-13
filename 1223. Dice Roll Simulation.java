class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        if (n == 1) return 6;
        List<Map<Integer, Integer>> cur = new ArrayList<>();
        for (int i = 0; i < 6; i++){
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            map.put(1, 1);
            cur.add(map);
        }
        for (int i = 1; i < n; i++){
            List<Map<Integer, Integer>> next = new ArrayList<>();
            for (int j = 0; j < 6; j++){
                Map<Integer, Integer> map = new HashMap<>();
                int countZero = 0;
                int countOne = 0;
                for (int k = 0; k < 6; k++){
                    if (k != j){
                        Map<Integer, Integer> kMap = cur.get(k);
                        countOne += kMap.get(0);
                        countOne %= 1000000007;
                    }
                }
                map.put(1, countOne);
                countZero += countOne;
                for (int k = 2; k <= rollMax[j]; k++){
                    int count = cur.get(j).getOrDefault(k - 1, 0) % 1000000007;
                    map.put(k, count);
                    countZero += count;
                    countZero %= 1000000007;
                }
                map.put(0, countZero);
                next.add(map);
            }
            cur = next;
        }
        int res = 0;
        for (int i = 0; i < 6; i++){
            res += cur.get(i).get(0);
            res %= 1000000007;
        }
        return res;
    }
}

//ACC