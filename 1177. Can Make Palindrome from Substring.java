class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        int[][] dp = new int[s.length() + 1][26];
        int[] cur = new int[26];
        dp[0] = cur.clone();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            cur[ch - 'a']++;
            dp[i + 1] = cur.clone();
        }
        for (int[] query: queries){
            res.add(helper(dp, query));
        }
        return res;
    }
    
    boolean helper(int[][] dp, int[] query){
        int count = 0;
        int[] left = dp[query[0]];
        int[] right = dp[query[1] + 1];
        for (int i = 0; i < 26; i++){
            count += (right[i] - left[i]) % 2;
        }
        return count / 2 <= query[2];
    }
}

// ACC