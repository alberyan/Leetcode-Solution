class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int n = 1;
        int index = 0;
        int[] res = new int[num_people];
       	while (n <= candies){
       		res[index] += n;
       		candies -= n;
       		n++;
       		index = (index + 1) % num_people;
       	}
       	res[index] += candies;
       	return res;
    }
}

// Runtime: 1 ms, faster than 90.11% of Java online submissions for Distribute Candies to People.
// Memory Usage: 33.8 MB, less than 100.00% of Java online submissions for Distribute Candies to People.