class Solution {
    public int minPartitions(String n) {
        int res = 0;
        for (char ch: n.toCharArray()) {
            res = Math.max(res, ch - '0');
        }
        return res;
    }
}