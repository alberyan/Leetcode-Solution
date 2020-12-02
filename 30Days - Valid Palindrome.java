class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (isAlp(arr[left]) && isAlp(arr[right])) {
                if (arr[left] == arr[right]) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            } else if (isAlp(arr[left])) {
                right--;
            } else if (isAlp(arr[right])) {
                left++;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
    
    private boolean isAlp(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }
}

// ACC