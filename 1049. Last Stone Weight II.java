class Solution {
	int min;
    public int lastStoneWeightII(int[] stones) {
    	min = Integer.MAX_VALUE;
    	dfs(stones, 0, 0);
    	return min;
    }

    private void dfs(int[] stones, int index, int total){
    	if (index >= stones.length){
    		min = Math.min(Math.abs(total), min);
            return;
    	}
    	dfs(stones, index + 1, total + stones[index]);
    	dfs(stones, index + 1, total - stones[index]);
    }
}

// TLE

class Solution {
    public int lastStoneWeightII(int[] stones) {
    	int sum = 0;
    	for (int i: stones){
    		sum += i;
    	}
    	Set<Integer> set = new HashSet<>();
    	int res = 0;
    	set.add(0);
    	for (int stone: stones){
    		Set<Integer> newSet = new HashSet<>();
    		for (int prev: set){
    			int newWeight = prev + stone;
    			if (newWeight <= sum / 2){
    				newSet.add(newWeight);
    				res = Math.max(res, newWeight);
    			}
    		}
    		set.addAll(newSet);
    	}
    	return sum - 2 * res;
    }
}

// Runtime: 10 ms, faster than 20.88% of Java online submissions for Last Stone Weight II.
// Memory Usage: 35.8 MB, less than 100.00% of Java online submissions for Last Stone Weight II.