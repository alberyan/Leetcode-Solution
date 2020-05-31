class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies < max) {
                res.add(false);
            }
            else {
                res.add(true);
            }
        }
        return res;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Kids With the Greatest Number of Candies.
// Memory Usage: 39.8 MB, less than 100.00% of Java online submissions for Kids With the Greatest Number of Candies.