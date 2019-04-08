class TimeMap {
    class Node{
        int time;
        String value;
        Node(int time, int value){
            this.time = time;
            this.value = value;
        }
    }

    class NodeComparator implements Comparator<Node>{
        public int compare(Node n1, Node n2){
            return n1.time - n2.time;
        }
    }

    Map<String, PriorityQueue<Node>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Node cur = new Node(timestamp, value);
        PriorityQueue<Node> pq = map.getOrDefault(key, new PriorityQueue<Node>());
        pq.offer(cur);
        map.put(key, pq);
    }

    public String get(String key, int timestamp) {
        Queue<Node> q = new LinkedList<>();
        PriorityQueue<Node> pq = map.get(key);
        if (pq == null || pq.peek().time > timestamp) return null;
        while (!pq.isEmpty()){
            if (pq.peek().time < timestamp) q.offer(pq.poll());
            else break;
        }
        String res = q.get(q.size() - 1);
        for (String s: q){
            pq.offer(s);
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
