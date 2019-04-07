class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int leftPar = 0;
        for (char ch: S.toCharArray()){
            if (ch == '('){
                if (leftPar > 0){
                    sb.append(ch);
                }
                leftPar++;
            } else {
                if (leftPar > 1){
                    sb.append(ch);
                }
                leftPar--;
            }
        }
        return sb.toString();
    }
}
