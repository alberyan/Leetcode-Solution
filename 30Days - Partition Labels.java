class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i++){
            lastIndex[S.charAt(i) - 'a'] = i;
        }
        
        int index = 0;
        while (index < S.length()){
            int last = lastIndex[S.charAt(index) - 'a'];
            int j = index + 1;
            while (j <= last){
                last = Math.max(lastIndex[S.charAt(j) - 'a'], last);
                j++;
            }
            res.add(j - index);
            index = j;
        }
        return res;
    }
}

// ACC