import javafx.util.Pair;

class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Pair<String, Double>> map = new HashMap<>();
        Map<String, Set<String>> pairKeyToStringMap = new HashMap<>();
        for (int i = 0; i < values.length; i++){
            String s1 = equations[i][0];
            String s2 = equations[i][1];
            double value = values[i];
            Pair<String, Double> pair1 = map.get(s1);
            Pair<String, Double> pair2 = map.get(s2);
            if (pair1 == null && pair2 == null){
                pair1 = new Pair<String, Double>(s2, value);
                pair2 = new Pair<String, Double>(s2, 1.0);
                Set<String> set = pairKeyToStringMap.getOrDefault(s2, new HashSet<>());
                set.add(s1);
                set.add(s2);
                pairKeyToStringMap.put(s2, set);
                map.put(s1, pair1);
                map.put(s2, pair2);
            } else if (pair1 == null){
                String rootString = pair2.getKey();
                double rootValue = pair2.getValue();
                pair1 = new Pair<String, Double>(rootString, value * rootValue);
                Set<String> set = pairKeyToStringMap.getOrDefault(rootString, new HashSet<>());
                set.add(s1);
                pairKeyToStringMap.put(rootString, set);
                map.put(s1, pair1);
            } else if (pair2 == null){
                String rootString = pair1.getKey();
                double rootValue = pair1.getValue();
                Set<String> set = pairKeyToStringMap.getOrDefault(rootString, new HashSet<>());
                set.add(s1);
                pairKeyToStringMap.put(rootString, set);
                pair2 = new Pair<String, Double>(rootString, rootValue / value);
                map.put(s2, pair2);
            } else {
                String rootString1 = pair1.getKey();
                double rootValue1 = pair1.getValue();
                String rootString2 = pair2.getKey();
                double rootValue2 = pair2.getValue();
                if (!rootString1.equals(rootString2)){
                    Set<String> set1 = pairKeyToStringMap.getOrDefault(rootString1, new HashSet<>());
                    Set<String> set2 = pairKeyToStringMap.getOrDefault(rootString2, new HashSet<>());
                    for (String s: set1){
                        set2.add(s);
                        Pair<String, Double> originPair = map.get(s);
                        map.put(s, new Pair<String, Double>(rootString2, originPair.getValue() * value * rootValue2 / rootValue1));
                    }
                    pairKeyToStringMap.put(rootString1, new HashSet<>());
                }
            }
        }

        double[] res = new double[queries.length];
        for (int i = 0; i < res.length; i++){
            String s1 = queries[i][0];
            String s2 = queries[i][1];
            Pair<String, Double> pair1 = map.get(s1);
            Pair<String, Double> pair2 = map.get(s2);
            if (pair1 == null || pair2 == null || !pair1.getKey().equals(pair2.getKey())){
                res[i] = -1.0;
            } else {
                res[i] = pair1.getValue() / pair2.getValue();
            }
        }
        return res;
    }
}

// Runtime: 2 ms, faster than 46.72% of Java online submissions for Evaluate Division.
// Memory Usage: 38 MB, less than 5.01% of Java online submissions for Evaluate Division.
