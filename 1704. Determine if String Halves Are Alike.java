class Solution {
    public boolean halvesAreAlike(String s) {
        int[] arrA = new int[128];
        int[] arrB = new int[128];
        for (char ch: s.substring(0, s.length() / 2).toCharArray()) {
            arrA[ch]++;
        }
        for (char ch: s.substring(s.length() / 2).toCharArray()) {
            arrB[ch]++;
        }
        int count = 0;
        for (char ch: "aeiouAEIOU".toCharArray()) {
            count = count + arrA[ch] - arrB[ch];
        }
        return count == 0;
    }
}