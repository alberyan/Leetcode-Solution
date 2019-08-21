class Solution {
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        int[] arr = new int[26];
        for (char ch: chars.toCharArray()){
            arr[ch - 'a']++;
        }
        for (String word: words){
            int[] count = arr.clone();
            boolean flag = true;
            for (char ch: word.toCharArray()){
                if (count[ch - 'a'] <= 0){
                    flag = false;
                    break;
                }
                count[ch - 'a']--;
            }
            if (flag) res += word.length();
        }
        return res;
    }
}

//ACC