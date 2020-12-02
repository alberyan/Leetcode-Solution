class Solution {
    public int heightChecker(int[] heights) {
        int[] correctHeights = heights.clone();
        Arrays.sort(correctHeights);
        int res = 0;
        for (int i = 0; i < correctHeights.length; i++){
            if (correctHeights[i] != heights[i]){
                res++;
            }
        }
        return res;
    }
}
