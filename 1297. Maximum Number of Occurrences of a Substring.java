import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int res = 0;
        for (int size = minSize; size <= maxSize; size++) {
            res = Math.max(res, helper(s, maxLetters, size));
        }
        return res;
    }

    private int helper(String s, int maxLetters, int size) {
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int[] digits = new int[26];
        int letters = 0;
        while (right < size){
            char ch = s.charAt(right);
            int cur = digits[ch - 'a'];
            if (cur == 0) letters++;
            digits[ch - 'a'] = cur + 1;
            right++;
        }
        if (letters <= maxLetters) {
            map.put(s.substring(0, right), 1);
            count = 1;
        }
        while (right < s.length()){
            char ch = s.charAt(right);
            int cur = digits[ch - 'a'];
            if (cur == 0) letters++;
            digits[ch - 'a'] = cur + 1;
            ch = s.charAt(left);
            cur = digits[ch - 'a'];
            if (cur == 1) letters--;
            digits[ch - 'a'] = cur - 1;
            if (letters <= maxLetters) {
                String curString = s.substring(left + 1, right + 1);
                int curCount = map.getOrDefault(curString, 0);
                map.put(curString, curCount + 1);
                count = Math.max(curCount + 1, count);
            }
            left++;
            right++;
        }
        return count;
    }
}

// Runtime: 182 ms, faster than 64.18% of Java online submissions for Maximum Number of Occurrences of a Substring.
// Memory Usage: 59.9 MB, less than 100.00% of Java online submissions for Maximum Number of Occurrences of a Substring.