class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (sb.length() == 0) continue;
                else {
                    res.insert(0, sb.toString(), 0, sb.length());
                    res.insert(0, " ", 0, 1);
                    sb = new StringBuilder();
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        if (sb.length() > 0) {
            res.insert(0, sb.toString(), 0, sb.length());
            return res.toString();
        } else {
            return res.length() > 0 ? res.toString().substring(1) : "";
        }
    }
}

// ACC