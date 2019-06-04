class Solution {
    public String gcdOfStrings(String str1, String str2) {
    	if (str1.equals(str2)) return str1;
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 < len2){
        	String tmp = str1;
        	str1 = str2;
        	str2 = tmp;
        	int tmpLen = len1;
        	len1 = len2;
        	len2 = tmpLen;
        }
        if (!str1.substring(0, len2).equals(str2)){
        	return "";
        }
        return gcdOfStrings(str1.substring(len2), str2);
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Greatest Common Divisor of Strings.
// Memory Usage: 35.1 MB, less than 100.00% of Java online submissions for Greatest Common Divisor of Strings.