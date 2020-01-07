class Solution {
    public String freqAlphabets(String s) {
        int len = s.length();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < len) {
            if (index + 2 < len && s.charAt(index + 2) == '#') {
                sb.append(intStringToChar(s.substring(index, index + 3)));
                index += 3;
            } else {
                sb.append(intStringToChar(s.substring(index, index + 1)));
                index++;
            }
        }
        return sb.toString();
    }

    private char intStringToChar(String s) {
        if (s.length() == 1) {
            char ch = (char)(s.charAt(0) - '0' - 1 + 'a');
            return ch;
        }
        else {
            char ch = (char)((s.charAt(0) - '0') * 10 + (s.charAt(1) - '0') - 1 + 'a');
            return ch;
        }
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Decrypt String from Alphabet to Integer Mapping.
// Memory Usage: 34.7 MB, less than 100.00% of Java online submissions for Decrypt String from Alphabet to Integer Mapping.