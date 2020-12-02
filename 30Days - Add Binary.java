class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int add = 0;
        int aLast = a.length() - 1;
        int bLast = b.length() - 1;
        while (aLast >= 0 || bLast >= 0) {
            int digit = add;
            if (aLast < 0) {
                digit += (b.charAt(bLast) - '0');
            } else if (bLast < 0) {
                digit += (a.charAt(aLast) - '0');
            } else {
                digit += (b.charAt(bLast) - '0') + (a.charAt(aLast) - '0');
            }
            add = digit / 2;
            digit %= 2;
            res.append(digit);
            aLast--;
            bLast--;
        }
        if (add > 0) {
            res.append(add);
        }
        return res.reverse().toString();
    }
}

// ACC