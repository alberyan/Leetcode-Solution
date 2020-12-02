class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banSet = new HashSet<>();
        for (String s: banned){
        	banSet.add(s);
        }
        Map<String, Integer> map = new HashMap<>();
        for (String s: paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ")){
        	if (!banSet.contains(s)){
        		map.put(s, map.getOrDefault(s, 0) + 1);
        	}
        }
        String res = "";
        for (String s: map.keySet()){
        	if (res.length() == 0 || map.get(s) > map.get(res)){
        		res = s;
        	}
        }
        return res;
    }
}