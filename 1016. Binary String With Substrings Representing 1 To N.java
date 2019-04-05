class Solution {
    public boolean queryString(String S, int N) {
        boolean[] reps = new boolean[N + 1];
        for (int i = 0; i < S.length(); i++){
            int cur = 0;
            for (int j = i; j < S.length(); j++){
                cur *= 2;
                if (S.charAt(j) == '1') cur++;
                if (cur > N) break;
                reps[cur] = true;
            }
        }
        for (int i = 1; i < reps.length; i++){
            if (!reps[i]) return false;
        }
        return true;
    }
}
