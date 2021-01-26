class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int[] rectangle : rectangles) {
            int len = Math.min(rectangle[0], rectangle[1]);
            map.put(len, map.getOrDefault(len, 0) + 1);
            maxLen = Math.max(maxLen, len);
        }
        return map.get(maxLen);
    }
}