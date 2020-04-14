class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) { 
            List<String> list = map.getOrDefault(getSortedString(str), new ArrayList<>());
            list.add(str);
            map.put(getSortedString(str), list);
        }
        for (String str: map.keySet()) {
            res.add(map.get(str));
        }
        return res;
    }

    private String getSortedString(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}

//ACC