class Solution {
    public int maxNumberOfBalloons(String text) {
        int res = text.length();
        int[] arr = new int[26];
        for (char ch: text.toCharArray()){
        	arr[ch - 'a']++;
        }
        for (char ch: "ban".toCharArray()){
        	res = Math.min(arr[ch - 'a'], res);
        }
        for (char ch: "lo".toCharArray()){
        	res = Math.min(arr[ch - 'a'] / 2, res);
        }
        return res;
    }
}

//ACC