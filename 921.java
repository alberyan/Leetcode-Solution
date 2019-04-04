class Solution {
    public int minAddToMakeValid(String S) {
        int leftP = 0;
        int rightP = 0;
        for (int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
          if (ch == '(') leftP++;
          if (ch == ')'){
            if (leftP > 0){
              leftP--;
            } else {
              rightP++;
            }
          }
        }
        return leftP + rightP;
    }
}
