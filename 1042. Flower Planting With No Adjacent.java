class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] res = new int[N];
        int[][] noColor = new int[N][4];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] path: paths){
            int x = path[0] - 1;
            int y = path[1] - 1;
            Set<Integer> setX = map.getOrDefault(x, new HashSet<>());
            setX.add(y);
            map.put(x, setX);
            Set<Integer> setY = map.getOrDefault(y, new HashSet<>());
            setY.add(x);
            map.put(y, setY);
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < 4; j++){
                if (noColor[i][j] == 0){
                    res[i] = j + 1;
                    break;
                }
            }
            int color = res[i];
            Set<Integer> set = map.getOrDefault(i, new HashSet<>());
            for (int j: set){
                noColor[j][color - 1] = -1;
            }
        }
        return res;
    }
}

// Runtime: 43 ms, faster than 40.57% of Java online submissions for Flower Planting With No Adjacent.
// Memory Usage: 53.1 MB, less than 100.00% of Java online submissions for Flower Planting With No Adjacent.
