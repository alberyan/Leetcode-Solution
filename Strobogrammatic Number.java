class Solution {
    public boolean isStrobogrammatic(String num) {
        int len = num.length();
        int left = -1;
        int right = len;
        while (left++ < right--){
        	if (num.charAt(left) == '8'){
        		if (num.charAt(right) == '8') continue;
        	}
        	if (num.charAt(left) == '1'){
        		if (num.charAt(right) == '1') continue;
        	}
        	if (num.charAt(left) == '6'){
        		if (num.charAt(right) == '9') continue;
        	}
        	if (num.charAt(left) == '0'){
        		if (num.charAt(right) == '0') continue;
        	}
        	if (num.charAt(left) == '9'){
        		if (num.charAt(right) == '6') continue;
        	}
        	return false;
        }
        return true;
    }
}

//ACC