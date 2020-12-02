class Solution {
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        if (index == -1) return 0;
        int res = 0;
        while (index >= 0) {
            if (s.charAt(index) == ' ') index--;
            else break;
        }
        while (index >= 0) {
            if (s.charAt(index) == ' ') return res;
            else res++;
            index--;
        }
        return res;
    }
}

// ACC