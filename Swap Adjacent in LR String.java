class Solution {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) return false;
        start = start.replaceAll('R', '');
		end = end.replaceAll('R', '');
		return start.equals(end);
    }
}