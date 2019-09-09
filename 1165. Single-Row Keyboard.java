class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] arr = new int[26];
        for (int i = 0; i < keyboard.length(); i++){
        	char ch = keyboard.charAt(i);
        	arr[ch - 'a'] = i;
        }
        int start = 0;
        int res = 0;
        for (char ch: word.toCharArray()){
        	int next = arr[ch - 'a'];
        	res += Math.abs(start - next);
        	start = next;
        }
        return res;
    }
}

// Acc