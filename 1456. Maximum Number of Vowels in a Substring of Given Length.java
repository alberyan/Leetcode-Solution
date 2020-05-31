class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vSet = new HashSet<>();
        vSet.add('a');
        vSet.add('e');
        vSet.add('i');
        vSet.add('o');
        vSet.add('u');
        int left = 0;
        int right = 0;
        int res = 0;
        int cur = 0;
        while (right < k) {
            if (vSet.contains(s.charAt(right))) {
                cur++;
                res = cur;
            }
            right++;
        }
        while (right < s.length()) {
            if (vSet.contains(s.charAt(left))) {
                cur--;
            }
            if (vSet.contains(s.charAt(right))) {
                cur++;
            }
            res = Math.max(res, cur);
            left++;
            right++;
        }
        return res;
    }
}

// Runtime: 17 ms, faster than 72.60% of Java online submissions for Maximum Number of Vowels in a Substring of Given Length.
// Memory Usage: 40.2 MB, less than 100.00% of Java online submissions for Maximum Number of Vowels in a Substring of Given Length.