class Solution {
    public String stringShift(String s, int[][] shift) {
        int finalShift = 0;
        for (int[] sh: shift) {
            if (sh[0] == 0) {
                finalShift += sh[1];
            }
            else {
                finalShift -= sh[1];
            }
        }
        if (finalShift == 0) return s;
        StringBuilder sb = new StringBuilder();
        while (finalShift < 0) {
            finalShift += s.length();
        }
        for (int i = finalShift; i < finalShift + s.length(); i++) {
            sb.append(s.charAt(i % s.length()));
        }
        return sb.toString();
    }
}

//ACC