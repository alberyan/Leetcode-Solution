class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for (String str: words) {
            for (String str1: words) {
                if (str1.indexOf(str) != -1 && str1 != str) {
                    res.add(str);
                    break;
                }
            }
        }
        return res;
    }
}

// Runtime: 3 ms, faster than 100.00% of Java online submissions for String Matching in an Array.
// Memory Usage: 40.1 MB, less than 100.00% of Java online submissions for String Matching in an Array.