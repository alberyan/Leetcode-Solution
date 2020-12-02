class Solution {
    public boolean isPathCrossing(String path) {
        int len = path.length();
        Set<Integer> set = new HashSet<>();
        int cur = 0;
        set.add(0);
        for (char ch: path.toCharArray()) {
            if (ch == 'N') cur += len;
            else if (ch == 'S') cur -= len;
            else if (ch == 'E') cur += 1;
            else if (ch == 'W') cur -= 1;
            if (set.contains(cur)) return true;
            set.add(cur);
        }
        return false;
    }
}

// Runtime: 1 ms, faster than 92.88% of Java online submissions for Path Crossing.
// Memory Usage: 39.6 MB, less than 100.00% of Java online submissions for Path Crossing.