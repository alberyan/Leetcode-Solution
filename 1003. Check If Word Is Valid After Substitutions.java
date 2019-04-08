class Solution {
    public boolean isValid(String S) {
        if (S.length() % 3 != 0) return false;
        while (true){
            String newString = S.replace("abc", "");
            if (newString.length() == 0){
                return true;
            }
            if (newString.length() == S.length()) return false;
            S = newString;
        }
    }
}
