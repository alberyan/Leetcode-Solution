class CombinationIterator {
    List<String> strArr;
    int index;

    public CombinationIterator(String characters, int combinationLength) {
        strArr = new ArrayList<>();
        index = -1;
        StringBuilder sb = new StringBuilder();
        build(strArr, characters, combinationLength, sb, 0);
    }
    
    private void build(List<String> strArr, String characters, int combinationLength, StringBuilder sb, int currentIndex) {
        if (combinationLength <= 0 || currentIndex >= characters.length()) return;
        for (int i = currentIndex; i < characters.length(); i++) {
            sb.append(characters.charAt(i));
            if (combinationLength == 1) {
                strArr.add(sb.toString());
            }
            else {
                build(strArr, characters, combinationLength - 1, sb, i + 1);
            }
            sb.setLength(sb.length() - 1);
        }
    }
    
    public String next() {
        return index++ >= strArr.size() ? "" : strArr.get(index);
    }
    
    public boolean hasNext() {
        return index + 1 < strArr.size();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

// Runtime: 12 ms, faster than 59.55% of Java online submissions for Iterator for Combination.
// Memory Usage: 42.6 MB, less than 100.00% of Java online submissions for Iterator for Combination.