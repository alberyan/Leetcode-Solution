class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) return i + 1;
        }
        return -1;
    }
}

///Runtime: 0 ms, faster than 100.00% of Java online submissions for Check If a Word Occurs As a Prefix of Any Word in a Sentence.
// Memory Usage: 37 MB, less than 100.00% of Java online submissions for Check If a Word Occurs As a Prefix of Any Word in a Sentence.