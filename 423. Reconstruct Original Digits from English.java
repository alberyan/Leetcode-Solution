class Solution {
    public String originalDigits(String s) {
        int[] arr = new int[26];
        int[] res = new int[11];
        res[10] = s.length();
        for (char ch: s.toCharArray()){
            arr[ch - 'a']++;
        }
        while (res[10] > 0){
            has("zero", 0, arr, res, arr['z' - 'a']);
            has("two", 2, arr, res, arr['w' - 'a']);
            has("four", 4, arr, res, arr['u' - 'a']);
            has("six", 6, arr, res, arr['x' - 'a']);
            has("eight", 8, arr, res, arr['g' - 'a']);
            has("seven", 7, arr, res, arr['s' - 'a']);
            has("five", 5, arr, res, arr['v' - 'a']);
            has("one", 1, arr, res, arr['o' - 'a']);
            has("three", 3, arr, res, arr['t' - 'a']);
            has("nine", 9, arr, res, arr['i' - 'a']);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < res[i]; j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }

    void has(String numString, int num, int[] arr, int[] res, int count){
        res[num] += count;
        res[10] -= numString.length() * count;
        for (char ch: numString.toCharArray()){
            arr[ch - 'a'] -= count;
        }
    }
}


// Runtime: 5 ms, faster than 91.89% of Java online submissions for Reconstruct Original Digits from English.
// Memory Usage: 38.3 MB, less than 96.08% of Java online submissions for Reconstruct Original Digits from English.
