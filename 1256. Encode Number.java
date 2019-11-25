class Solution {
    public String encode(int num) {
        if (num == 0) return "";
        int n = 1;
        int count = 2;
        while (count < num) {
        	num -= count;
        	n++;
        	count *= 2;
        }
        num--;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
        	sb.append(num % 2 + "");
        	num /= 2;
        }
        for (int i = sb.length() + 1; i <= n; i++){
        	sb.append("0");
        }
        return sb.reverse().toString();
    }
}

//ACC