class Solution {
    public int trap(int[] height) {
        int[] leftHighest = new int[height.length];
        int maxHeight = 0;
        for (int i = 0; i < height.length; i++){
            maxHeight = Math.max(maxHeight, height[i]);
            leftHighest[i] = maxHeight;
        }
        int[] rightHighest = new int[height.length];
        maxHeight = 0;
        for (int i = height.length - 1; i >= 0; i--){
            maxHeight = Math.max(maxHeight, height[i]);
            rightHighest[i] = maxHeight;
        }
        int res = 0;
        for (int i = 0; i < height.length; i++){
            res += Math.min(leftHighest[i], rightHighest[i]) - height[i];
        }
        return res;
    }
}

//ACC