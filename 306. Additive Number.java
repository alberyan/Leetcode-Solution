class Solution {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i < num.length(); i++){
            for (int j = i + 1; j < num.length(); j++){
                if (check(num, 0, i, j)) return true;
            }
        }
        return false;
    }

    boolean check(String num, int a, int b, int c){
        String first = num.substring(a, b);
        String second = num.substring(b, c);
        String res = num.substring(c);
        if ((first.startsWith("0") && first.length() > 1) ||
        (second.startsWith("0") && second.length() > 1) ||
        (res.startsWith("0") && res.length() > 1)) return false;
        String sum = addStrings(first, second);
        if (sum.equals(res)) return true;
        if (res.startsWith(sum)) return check(num, b, c, c + sum.length());
        return false;
    }

    String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}

// Runtime: 1 ms, faster than 93.31% of Java online submissions for Additive Number.
// Memory Usage: 35.7 MB, less than 26.67% of Java online submissions for Additive Number.
