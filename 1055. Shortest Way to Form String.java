class Solution {
    public int shortestWay(String source, String target) {
        int res = 0;
        int targetIndex = 0;
        int lastTargetIndex = targetIndex;
        while (targetIndex < target.length()){
            int sourceIndex = 0;
            while (sourceIndex < source.length() && targetIndex < target.length()){
                if (target.charAt(targetIndex) == source.charAt(sourceIndex++)) targetIndex++;
            }
            res++;
            if (targetIndex == lastTargetIndex) return -1;
            lastTargetIndex = targetIndex;
        }
        return res;
    }
}

// Runtime: 4 ms, faster than 55.25% of Java online submissions for Shortest Way to Form String.
// Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Shortest Way to Form String.