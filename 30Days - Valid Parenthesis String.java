class Solution {
    public boolean checkValidString(String s) {
        return isValid(0, 0, s);
    }

    boolean isValid(int cur, int index, String s) {
        if (index == s.length()) {
            return cur == 0;
        }
        char ch = s.charAt(index);
        if (ch == '(') return isValid(cur - 1, index + 1, s);
        else if (ch == ')') {
            if (cur >= 0) return false;
            else return isValid(cur + 1, index + 1, s);
        }
        else {
            if (isValid(cur, index + 1, s)) return true; // Empty
            if (isValid(cur - 1, index + 1, s)) return true; // '('
            if (cur >= 0) return false;
            else return isValid(cur + 1, index + 1, s);// ')'
        }
    }
}

//ACC