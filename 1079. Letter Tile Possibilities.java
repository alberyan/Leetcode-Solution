class Solution {
    public int numTilePossibilities(String tiles) {
        int[] charArr = new int[26];
        for (char ch: tiles.toCharArray()){
        	charArr[ch - 'A']++;
        }
        return dfs(charArr);
    }

    int dfs(int[] arr) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) continue;
            sum++;
            arr[i]--;
            sum += dfs(arr);
            arr[i]++;
        }
        return sum;
    }
}

// Runtime: 2 ms, faster than 89.96% of Java online submissions for Letter Tile Possibilities.
// Memory Usage: 33.8 MB, less than 100.00% of Java online submissions for Letter Tile Possibilities.