class TimeMap {
    class Node{
        int time;
        String value;
        Node(int time, String value){
            this.time = time;
            this.value = value;
        }
    }

    Map<String, List<Node>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Node cur = new Node(timestamp, value);
        List<Node> list = map.getOrDefault(key, new ArrayList<>());
        list.add(cur);
        map.put(key, list);
    }

    public String get(String key, int timestamp) {
        List<Node> list = map.get(key);
        if (list == null || list.get(0).time > timestamp) return "";
        int left = 0;
        int right = list.size() - 1;
        if (timestamp >= list.get(right).time) return list.get(right).value;
        while (left < right - 1){
            int mid = (left + right) / 2;
            Node midNode = list.get(mid);
            if (midNode.time == timestamp) return midNode.value;
            else if (midNode.time > timestamp) right = mid;
            else left = mid;
        }
        return list.get(left).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

// Runtime: 182 ms, faster than 98.17% of Java online submissions for Time Based Key-Value Store.
// Memory Usage: 134.2 MB, less than 96.60% of Java online submissions for Time Based Key-Value Store.