class Solution {
    public String multiply(String num1, String num2) {
    	int len = num2.length();
        String[] arr = new String[len];
        for (int i = 0; i < len; i++){
        	int digit = num2.charAt(len - 1 - i) - '0';
        	StringBuilder sb = new StringBuilder();
        	sb.append(multiply(num1, digit));
        	if (!sb.toString().equals("0")){
        		for (int j = 0; j < i; j++) sb.append('0');
        	}
        	arr[i] = sb.toString();
        }
        String res = "0";
        for (String s: arr){
        	res = add(res, s);
        }
        return res;
    }

    String multiply(String num, int digit){
    	if (digit == 0) return "0";
    	if (digit == 1) return num;
    	StringBuilder sb = new StringBuilder();
    	int add = 0;
    	for (int i = num.length() - 1; i >= 0; i--){
    		int cur = (num.charAt(i) - '0') * digit + add;
    		sb.append(cur % 10);
    		add = cur / 10;
    	}
    	if (add > 0) sb.append(add);
    	return sb.reverse().toString();
    }

    String add(String num1, String num2){
    	StringBuilder sb = new StringBuilder();
    	int add = 0;
    	for (int i = 0; i < Math.max(num1.length(), num2.length()); i++){
    		int cur = add;
    		if (i >= num1.length()) cur += (num2.charAt(num2.length() - 1 - i) - '0');
    		else if (i >= num2.length()) cur += (num1.charAt(num1.length() - 1 - i) - '0');
    		else cur += (num2.charAt(num2.length() - 1 - i) - '0') + (num1.charAt(num1.length() - 1 - i) - '0');
    		sb.append(cur % 10);
    		add = cur / 10;
    	}
    	if (add > 0) sb.append(add);
    	return sb.reverse().toString();
    }
}

//ACC