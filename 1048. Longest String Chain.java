class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());
        int res = 1;
        int len = words.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (isPre(words[j], words[i])){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    boolean isPre(String s1, String s2){
        if (s1.length() + 1 != s2.length()) return false;
        boolean flag = false;
        int i1 = 0;
        int i2 = 0;
        while (i1 < s1.length()){
            if (s1.charAt(i1) != s2.charAt(i2)){
                if (!flag){
                    flag = true;
                    i2++;
                    continue;
                } else {
                    return false;
                }
            }
            i1++;
            i2++;
        }
        return true;
    }
}


// Runtime: 60 ms, faster than 47.02% of Java online submissions for Longest String Chain.
// Memory Usage: 37.1 MB, less than 100.00% of Java online submissions for Longest String Chain.
