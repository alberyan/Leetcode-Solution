class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();
        
        for (List<String> ticket: tickets){
            if (!map.containsKey(ticket.get(0))){
                map.put(ticket.get(0), new PriorityQueue<>());
            }
            map.get(ticket.get(0)).offer(ticket.get(1));
        }
        
        dfs("JFK", map, res);
        return res;
    }
    
    public void dfs(String s, Map<String, PriorityQueue<String>> map, LinkedList<String> res){
        PriorityQueue<String> q = map.get(s);
        while (q != null && !q.isEmpty()){
            dfs(q.poll(), map, res);
        }
        
        res.addFirst(s);
    }
}

// ACC