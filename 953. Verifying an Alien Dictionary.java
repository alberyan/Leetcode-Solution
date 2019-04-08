class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < 26; i++){
            map.put(order.charAt(i), (char)(i + 'a'));
        }
        for (int i = 0; i < words.length; i++){
            StringBuilder sb = new StringBuilder();
            for (char ch: words[i].toCharArray()){
                sb.append(map.get(ch));
            }
            words[i] = sb.toString();
        }
        for (int i = 0; i < words.length - 1; i++){
            if (words[i].compareTo(words[i + 1]) > 0) return false;
        }
        return true;
    }
}

// Runtime: 5 ms, faster than 29.45% of Java online submissions for Verifying an Alien Dictionary.
// Memory Usage: 39.5 MB, less than 5.37% of Java online submissions for Verifying an Alien Dictionary.
