class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int len = books.length;
        int[] acc = new int[len];
        acc[0] = books[0][0];
        for (int i = 1; i < len; i++){
            acc[i] = books[i][0] + acc[i - 1];
        }
        
        int[] dp = new int[len];
        dp[0] = books[0][1];
        int maxHeight = books[0][1];
        for (int i = 1; i < len; i++){
            maxHeight = Math.max(maxHeight, books[i][1]);
            if (acc[i] <= shelf_width){
                dp[i] = maxHeight;
                continue;
            }
            dp[i] = Integer.MAX_VALUE;
            int localMax = books[i][1];
            for (int j = i - 1; j >= 0 && acc[i] - acc[j] <= shelf_width; j--){
                localMax = Math.max(books[j + 1][1], localMax);
                dp[i] = Math.min(dp[j] + localMax, dp[i]);
            }
        }
        return dp[len - 1];
    }

}

// Runtime: 1 ms, faster than 55.65% of Java online submissions for Filling Bookcase Shelves.
// Memory Usage: 40.8 MB, less than 100.00% of Java online submissions for Filling Bookcase Shelves.