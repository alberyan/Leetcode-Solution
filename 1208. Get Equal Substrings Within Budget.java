class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] diffs = new int[s.length()];
        for (int i = 0; i < s.length(); i++){
        	diffs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int res = 0;
        int cur = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()){
        	cur += diffs[right];
        	right++;
        	while (cur > maxCost){
        		cur -= diffs[left];
        		left++;
        	}
        	res = Math.max(res, right - left);
        }
        return res;
    }
}

//ACC