class Solution1 {
    public String arrangeWords(String text) {
        Map<String, List<Integer>> map = new HashMap<>();
        String[] arr = text.split(" ");
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.getOrDefault(arr[i].toLowerCase(), new LinkedList<>());
            list.add(i);
            map.put(arr[i].toLowerCase(), list);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() < s2.length()) return -1;
                if (s1.length() > s2.length()) return 1;
                return map.get(s1).get(0) - map.get(s2).get(0);
            }
        });
        for (String s: map.keySet()) {
            pq.offer(s);
        }
        StringBuilder sb = new StringBuilder();
        String first = pq.poll();
        List<Integer> firstList = map.get(first);
        sb.append(first.substring(0, 1).toUpperCase() + first.substring(1));
        firstList.remove(0);
        if (!firstList.isEmpty()) {
            pq.offer(first);
        }
        while (!pq.isEmpty()) {
            sb.append(" ");
            String cur = pq.poll();
            sb.append(cur);
            List<Integer> list = map.get(cur);
            list.remove(0);
            if (!list.isEmpty()) {
                pq.offer(cur);
            }
        }
        return sb.toString();
    }
}

// Runtime: 62 ms, faster than 33.67% of Java online submissions for Rearrange Words in a Sentence.
// Memory Usage: 40.6 MB, less than 100.00% of Java online submissions for Rearrange Words in a Sentence.

class Solution {
    public String arrangeWords(String text) {
        Map<Integer, StringBuilder> map = new HashMap<>();
        String[] arr = text.split(" ");
        for (String s: arr) {
            int len = s.length();
            StringBuilder sb = map.getOrDefault(len, new StringBuilder());
            sb.append(" ");
            sb.append(s.toLowerCase());
            map.put(len, sb);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int len: list) {
            sb.append(map.get(len).toString());
        }
        String tmp = sb.toString();
        return tmp.substring(1, 2).toUpperCase() + tmp.substring(2);
    }
}

// Runtime: 18 ms, faster than 94.24% of Java online submissions for Rearrange Words in a Sentence.
// Memory Usage: 41.4 MB, less than 100.00% of Java online submissions for Rearrange Words in a Sentence.