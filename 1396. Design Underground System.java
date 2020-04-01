class UndergroundSystem {
    class Node {
        String stationName;
        int t;
        public Node(String stationName, int t) {
            this.stationName = stationName;
            this.t = t;
        }
    }

    class TimeCount {
        double sumTime;
        int count;
        public TimeCount() {
            this.sumTime = 0;
            this.count = 0;
        }
    }

    Map<Integer, Node> entryMap;
    Map<String, TimeCount> stationMap;
    
    public UndergroundSystem() {
        entryMap = new HashMap<>();
        stationMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Node newNode = new Node(stationName, t);
        entryMap.put(id, newNode);
    }
    
    public void checkOut(int id, String stationName, int t) {
        Node checkInNode = entryMap.get(id);
        String stations = checkInNode.stationName + "-" + stationName;
        TimeCount timeCount = stationMap.getOrDefault(stations, new TimeCount());
        timeCount.sumTime += t - checkInNode.t;
        timeCount.count++;
        stationMap.put(stations, timeCount);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String stations = startStation + "-" + endStation;
        TimeCount timeCount = stationMap.getOrDefault(stations, new TimeCount());
        return timeCount.sumTime  / timeCount.count;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */

// Runtime: 71 ms, faster than 85.66% of Java online submissions for Design Underground System.
// Memory Usage: 52.5 MB, less than 100.00% of Java online submissions for Design Underground System.