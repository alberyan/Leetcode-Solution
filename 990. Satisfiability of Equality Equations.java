class Solution {
    public boolean equationsPossible(String[] equations) {
        Map<Character, Character> map = new HashMap<>();
        for (String equation : equations){
            if (equation.charAt(1) == '!') continue;
            char ch1 = equation.charAt(0);
            char ch2 = equation.charAt(3);
            Character get1 = map.get(ch1);
            Character get2 = map.get(ch2);
            if (get1 == null && get2 == null){
                map.put(ch1, ch1);
                map.put(ch2, ch1);
            } else if (get1 == null){
                map.put(ch1, get2);
            } else if (get2 == null){
                map.put(ch2, get1);
            } else {
                if (get1 == get2) continue;
                else {
                    for (Character key: map.keySet()){
                        if (map.get(key) == get2){
                            map.put(key, get1);
                        }
                    }
                }
            }
        }
        for (String equation : equations){
            if (equation.charAt(1) == '=') continue;
            char ch1 = equation.charAt(0);
            char ch2 = equation.charAt(3);
            if (ch1 == ch2) return false;
            Character get1 = map.get(ch1);
            Character get2 = map.get(ch2);
            if (get1 == null || get2 == null || get1 != get2){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}

// Runtime: 2 ms, faster than 96.62% of Java online submissions for Satisfiability of Equality Equations.
// Memory Usage: 37.5 MB, less than 90.85% of Java online submissions for Satisfiability of Equality Equations.
