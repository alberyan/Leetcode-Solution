class Solution {
    public int integerReplacement(int n) {
        Set<Long> visited = new HashSet<>();
        Queue<Long> q = new LinkedList<>();
        q.offer((long)n);
        int res = 0;
        while (!q.isEmpty()){
            Queue<Long> next = new LinkedList<>();
            while (!q.isEmpty()){
                long cur = q.poll();
                if (cur == 1) return res;
                visited.add(cur);
                if (cur % 2 == 0){
                    long a = cur / 2;
                    if (!visited.contains(a)) next.offer(a);
                } else {
                    long a = cur + 1;
                    if (!visited.contains(a)) next.offer(a);
                    long b = cur - 1;
                    if (!visited.contains(b)) next.offer(b);
                }
            }
            q = next;
            res++;
        }
        return res;
    }
}

// Runtime: 3 ms, faster than 49.70% of Java online submissions for Integer Replacement.
// Memory Usage: 32.3 MB, less than 100.00% of Java online submissions for Integer Replacement.
