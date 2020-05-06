class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr, -2);
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if (arr[ch] >= 0) arr[ch] = -1;
            else if (arr[ch] == -2) arr[ch] = i;
        }
        int res = s.length();
        for (int a: arr) {
            if (a >= 0) {
                res = Math.min(res, a);
            }
        }
        return res == s.length() ? -1 : res;
    }
}

//ACC