class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] arr1 = new int[26];
        for (char ch : s1.toCharArray()) {
            arr1[ch - 'a']++;
        }
        int left = 0;
        int right = 0;
        int[] arr2 = new int[26];
        while (right < s1.length()) {
            arr2[s2.charAt(right) - 'a']++;
            right++;
        }
        if (match(arr1, arr2))
            return true;
        while (right < s2.length()) {
            arr2[s2.charAt(right) - 'a']++;
            arr2[s2.charAt(left) - 'a']--;
            right++;
            left++;
            if (match(arr1, arr2))
                return true;
        }
        return false;
    }

    private boolean match(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
}

//ACC