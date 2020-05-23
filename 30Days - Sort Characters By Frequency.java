class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<>(){
           @Override
            public int compare(Character ch1, Character ch2) {
                return map.get(ch2) - map.get(ch1);
            }
        });
        for (char ch: map.keySet()) {
            pq.offer(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char ch = pq.poll();
            for (int i = 0; i < map.get(ch); i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

//ACC