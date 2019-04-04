class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int n = 0;
        List<Boolean> res = new LinkedList<>();
        for (int i: A){
            n = (n * 2 + i) % 5;
            if (n == 0) res.add(true);
            else res.add(false);
        }
        return res;
    }
}
