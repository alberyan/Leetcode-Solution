class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            list.add(i);
        }
        Collections.sort(list, (Integer a, Integer b) -> (a.toString().compareTo(b.toString())));
        return list;
    }
}

// Runtime: 48 ms, faster than 7.24% of Java online submissions for Lexicographical Numbers.
// Memory Usage: 37 MB, less than 100.00% of Java online submissions for Lexicographical Numbers.
