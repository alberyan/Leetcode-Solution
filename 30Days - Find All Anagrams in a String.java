class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;
        int[] pArray = new int[26];
        for (char ch : p.toCharArray()) {
            pArray[ch - 'a']++;
        }
        int left = 0;
        int right = 0;
        int[] sArray = new int[26];
        while (right < p.length()) {
            sArray[s.charAt(right) - 'a']++;
            right++;
        }
        if (match(pArray, sArray))
            res.add(left);
        while (right < s.length()) {
            sArray[s.charAt(right) - 'a']++;
            right++;
            sArray[s.charAt(left) - 'a']--;
            left++;
            if (match(pArray, sArray))
                res.add(left);
        }
        return res;
    }

    private boolean match(int[] pArray, int[] sArray) {
        for (int i = 0; i < 26; i++) {
            if (pArray[i] != sArray[i])
                return false;
        }
        return true;
    }
}

//ACC