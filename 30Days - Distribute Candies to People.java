class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] arr = new int[num_people];
        int cur = 0;
        int index = 0;
        while (candies > 0) {
            cur = Math.min(cur + 1, candies);
            arr[index] += cur;
            index = (index + 1) % num_people;
            candies -= cur;
        }
        return arr;
    }
}

// ACC