class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String q: queries){
            res.add(isMatch(q, pattern));
        }
        return res;
    }

    boolean isMatch(String q, String pattern){
        int qIndex = 0;
        int pIndex = 0;
        while (qIndex < q.length()){
            char ch = q.charAt(qIndex);
            qIndex++;
            if (ch >= 'a' && ch <= 'z'){
                if (pIndex >= pattern.length() || pattern.charAt(pIndex) != ch) continue;
                else pIndex++;
            } else {
                if (pIndex >= pattern.length() || pattern.charAt(pIndex) != ch) return false;
                pIndex++;
            }

        }
        return pIndex == pattern.length();
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Camelcase Matching.
// Memory Usage: 35.8 MB, less than 100.00% of Java online submissions for Camelcase Matching.
