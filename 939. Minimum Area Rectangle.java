class Solution {
    public int minAreaRect(int[][] points) {
        int res = Integer.MAX_VALUE;
        Map<Integer, Set<Integer>> xMap = new HashMap<>();
        for (int[] point: points){
            int x = point[0];
            int y = point[1];
            Set<Integer> ySet = xMap.getOrDefault(x, new HashSet<>());
            ySet.add(y);
            xMap.put(x, ySet);
        }
        List<Integer> validXList = new ArrayList<>();
        for (Integer x: xMap.keySet()){
            if (xMap.get(x).size() > 1){
                validXList.add(x);
            }
        }
        for (int i = 0; i < validXList.size(); i++){
            for (int j = i + 1; j < validXList.size(); j++){
                int x1 = validXList.get(i);
                int x2 = validXList.get(j);
                Set<Integer> y1Set = xMap.get(x1);
                Set<Integer> y2Set = xMap.get(x2);
                List<Integer> list = new ArrayList<>();
                for (Integer y: y1Set){
                    if (y2Set.contains(y)){
                        list.add(y);
                    }
                }
                if (list.size() > 1){
                    for (int y1 = 0; y1 < list.size(); y1++){
                        for (int y2 = y1 + 1; y2 < list.size(); y2++){
                            res = Math.min(res, Math.abs((x1 - x2) * (list.get(y1) - list.get(y2))));
                        }
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE? 0: res;
    }
}

// Runtime: 115 ms, faster than 96.37% of Java online submissions for Minimum Area Rectangle.
// Memory Usage: 52.5 MB, less than 79.60% of Java online submissions for Minimum Area Rectangle.
