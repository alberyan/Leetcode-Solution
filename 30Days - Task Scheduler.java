class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int valMax = 0;
        int countMaxValue = 0;
        for (Map.Entry<Character, Integer> me: map.entrySet()){
            if (me.getValue() > valMax){
                valMax = me.getValue();
                countMaxValue = -1;
            }
            if (me.getValue() == valMax){
                countMaxValue++;
            }
        }
        
        int last = (valMax - 1) * n + valMax + countMaxValue;
        
        return Math.max(last, tasks.length);
    }
}

// ACC