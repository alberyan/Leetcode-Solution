class Solution {
    public String lastSubstring(String s) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 26; i++){
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < s.length(); i++){
            int digit = s.charAt(i) - 'a';
            list.get(digit).add(i);
        }
        int maxDigit = 26;
        for (int i = 25; i >= 0; i--){
            if (list.get(i).size() > 0){
                maxDigit = i;
                break;
            }   
        }
        if (maxDigit == 0) return s;
        return s.substring(helper(list.get(maxDigit), s));
    }
    
    int helper(List<Integer> list, String s){
        if (list.size() == 1) return list.get(0);
        List<Integer> next = new ArrayList<>();
        char maxCh = 'a';
        for (int loc: list){
            if (loc + 1 >= s.length()) continue;
            char cur = s.charAt(loc + 1);
            if (cur > maxCh){
                maxCh = cur;
                next = new ArrayList<>();
                next.add(loc + 1);
            } else if (cur == maxCh){
                next.add(loc + 1);
            }
        }
        return helper(next, s) - 1;
    }
}

// Acc