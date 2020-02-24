class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i: arr) {
            if (set.contains(i * 2)) return true;
            if (i % 2 == 0 && set.contains(i / 2)) return true;
            set.add(i);
        }
        return false;
    }
}

// Runtime: 1 ms, faster than 99.59% of Java online submissions for Check If N and Its Double Exist.
// Memory Usage: 39.1 MB, less than 100.00% of Java online submissions for Check If N and Its Double Exist.