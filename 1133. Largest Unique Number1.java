class Solution {
    public int largestUniqueNumber(int[] A) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> moreVisit = new HashSet<>();
        for (int a: A){
            if (visited.contains(a)){
                visited.remove(a);
                moreVisit.add(a);
            } else if (!moreVisit.contains(a)){
                visited.add(a);
            }
        }
        int res = -1;
        for (int a: visited){
            res = Math.max(res, a);
        }
        return res;
    }
}

// acc