class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word: words){
            if (fitPattern(word, pattern)){
              res.add(word);
            }
        }
        return res;
    }

    private boolean fitPattern(String word, String pattern){
      if (word.length() != pattern.length()) return false;
      Map<Character, Character> WtoP = new HashMap<>();
      Map<Character, Character> PtoW = new HashMap<>();
      for (int i = 0; i < word.length(); i++){
        char w = word.charAt(i);
        char p = pattern.charAt(i);
        Character foundP = WtoP.get(w);
        Character foundW = PtoW.get(p);
        if (foundP == null && foundW == null){
          WtoP.put(w, p);
          PtoW.put(p, w);
        } else if (foundP == null || foundW == null){
          return false;
        } else {
          if (foundP != p || foundW != w){
            return false;
          }
        }
      }
      return true;
    }
}
