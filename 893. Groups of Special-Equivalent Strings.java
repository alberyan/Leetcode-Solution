class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String S: A){
            int[] arr = new int[52];
            for (int i = 0; i < S.length(); i++){
                if (i % 2 == 0){
                    arr[S.charAt(i) - 'a']++;
                } else {
                    arr[S.charAt(i) - 'a' + 26]++;
                }
            }
            set.add(Arrays.toString(arr));
        }
        return set.size();
    }
}

// Runtime: 11 ms, faster than 69.14% of Java online submissions for Groups of Special-Equivalent Strings.
// Memory Usage: 38 MB, less than 61.54% of Java online submissions for Groups of Special-Equivalent Strings.
