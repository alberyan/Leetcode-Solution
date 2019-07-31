class Solution {
    public boolean backspaceCompare(String S, String T) {
        int sIndex = S.length() - 1;
        int tIndex = T.length() - 1;
        while (true){
            sIndex = back(S, sIndex);
            tIndex = back(T, tIndex);
            if (sIndex == -1 || tIndex == -1) return sIndex == tIndex;
            if (S.charAt(sIndex) != T.charAt(tIndex)) return false;
            sIndex--;
            tIndex--;
        }
    }
    
    int back(String S, int index){
        int count = 0;
        while (index >= 0){
            if (S.charAt(index) == '#'){
                count++;
                index--;
            } else {
                if (count > 0){
                    count--;
                    index--;
                } else {
                    return index;
                }
            }
        }
        return index;
    }
}

// O(N) time && O(1) space