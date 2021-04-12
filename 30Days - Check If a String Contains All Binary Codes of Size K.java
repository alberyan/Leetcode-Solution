class Solution {
    public boolean hasAllCodes(String s, int k) {
        int count = 1;
        for (int i = 0; i < k; i++) {
            count *= 2;
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i + k < s.length(); i++) {
            set.add(s.substring(i, i + k));
        }
        if (s.length() >= k) {
            set.add(s.substring(s.length() - k));
        }
        return set.size() == count;
    }
}