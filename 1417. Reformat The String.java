class Solution {
    public String reformat(String s) {
        List<Character> letters = new ArrayList<>();
        List<Character> numbers = new ArrayList<>();
        for (char ch: s.toCharArray()) {
            if (ch >= '0' && ch <= '9') numbers.add(ch);
            else letters.add(ch);
        }
        if (Math.abs(letters.size() - numbers.size()) > 1) return "";
        StringBuilder sb = new StringBuilder();
        List<Character> longer = letters.size() > numbers.size() ? letters: numbers;
        List<Character> shorter = letters.size() > numbers.size() ? numbers: letters;
        int index = 0;
        while (index < longer.size() || index < shorter.size()) {
            sb.append(longer.get(index));
            if (index < shorter.size()) {
                sb.append(shorter.get(index));
            }
            index++;
        }
        return sb.toString();
    }
}

// Runtime: 4 ms, faster than 93.17% of Java online submissions for Reformat The String.
// Memory Usage: 39.9 MB, less than 100.00% of Java online submissions for Reformat The String.