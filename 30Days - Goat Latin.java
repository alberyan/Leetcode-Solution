class Solution {
    public String toGoatLatin(String S) {
        String[] arr = S.split(" ");
        for (int i = 0; i < arr.length; i++) {
            String cur = arr[i];
            char ch = cur.charAt(0);
            StringBuilder sb = new StringBuilder();
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                sb.append(cur);
            } else {
                sb.append(cur.substring(1)).append(cur.substring(0, 1));
            }
            sb.append("ma");
            for (int j = -1; j < i; j++) {
                sb.append("a");
            }
            arr[i] = sb.toString();
        }
        return String.join(" ", arr);
    }
}

// ACC