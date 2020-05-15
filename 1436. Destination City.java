class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, Boolean> map = new HashMap<>();
        for (List<String> path : paths) {
            map.put(path.get(0), false && map.getOrDefault(path.get(0), true));
            map.put(path.get(1), true && map.getOrDefault(path.get(1), true));
        }
        for (String city : map.keySet()) {
            if (map.get(city))
                return city;
        }
        return "";
    }
}

// Runtime: 2 ms, faster than 83.00% of Java online submissions for Destination
// City.
// Memory Usage: 39 MB, less than 100.00% of Java online submissions for
// Destination City.