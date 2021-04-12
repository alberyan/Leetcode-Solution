class Solution {
    public boolean halvesAreAlike(String s) {
        int left = 0;
        int right = s.length() - 1;
        int count = 0;
        while (left < right) {
            char chL = s.charAt(left++);
            char chR = s.charAt(right--);
            if (chL == 'a' || chL == 'e' || chL == 'i' || chL == 'o' || chL == 'u' || chL == 'A' || chL == 'E' || chL == 'I' || chL == 'O' || chL == 'U') count++;
            if (chR == 'a' || chR == 'e' || chR == 'i' || chR == 'o' || chR == 'u' || chR == 'A' || chR == 'E' || chR == 'I' || chR == 'O' || chR == 'U') count--;
        }
        return count == 0;
    }
}