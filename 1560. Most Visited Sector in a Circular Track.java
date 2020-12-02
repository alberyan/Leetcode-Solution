class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        boolean[] arr = new boolean[n + 1];
        List<Integer> res = new LinkedList<>();
        int start = rounds[0];
        int end = rounds[rounds.length - 1];
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                arr[i] = true;
            }
        } else {
            for (int i = start; i <= end + n; i++) {
                arr[i % n == 0 ? n : i % n] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (arr[i]) {
                res.add(i);
            }
        }
        return res;
    }
}

//Runtime: 1 ms, faster than 96.00% of Java online submissions for Most Visited Sector in a Circular Track.
//Memory Usage: 39.7 MB, less than 81.23% of Java online submissions for Most Visited Sector in a Circular Track.