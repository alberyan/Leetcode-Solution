class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = -1;
        }
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a';
            if (arr[cur] == -1) {
                arr[cur] = i;
            } else {
                res = Math.max(res, i - arr[cur] - 1);
            }
        }
        return res;
    }
}