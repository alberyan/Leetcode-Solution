class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0;){
        	int n = 0;
        	while (n < K && i >= 0){
        		char ch = S.charAt(i);
        		if (ch != '-'){
        			n++;
                    if (ch >= 'a' && ch <= 'z'){
                        ch = (char)(ch + 'A' - 'a');
                    }
        			sb.append(ch);
        		}
                i--;
        	}
        	sb.append('-');
        }
        String res = sb.reverse().toString();
        int i = 0;
        while (i < res.length() && res.charAt(i) == '-'){
            i++;
        }
        return i < res.length() ? res.substring(i): "";
    }
}

//Accept