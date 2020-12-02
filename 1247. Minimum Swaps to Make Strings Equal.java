class Solution {
    public int minimumSwap(String s1, String s2) {
        int xToY = 0, yToX = 0;
        for (int i = 0; i < s1.length(); i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if (ch1 == ch2) continue;
            if (ch1 == 'x') xToY++;
            if (ch1 == 'y') yToX++;
        }
        if ((xToY + yToX) % 2 != 0) return -1;
        int max = Math.max(xToY, yToX);
        int min = Math.min(xToY, yToX);
        return min + (max - min) / 2;
    }
}