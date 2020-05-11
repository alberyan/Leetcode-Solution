class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new LinkedList<>();
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (index >= target.length)
                return res;
            res.add("Push");
            if (target[index] != i) {
                res.add("Pop");
            } else {
                index++;
            }
        }
        return res;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Build an
// Array With Stack Operations.
// Memory Usage: 39.5 MB, less than 100.00% of Java online submissions for Build
// an Array With Stack Operations.