class Solution {
    public int[] asteroidCollision(int[] asteroids) {
    	Deque<Integer> stack = new ArrayDeque<>();
    	for (int asteroid: asteroids){
    		if (stack.isEmpty() || asteroid > 0){
    			stack.offerFirst(asteroid);
    			continue;
    		}
    		boolean newAsteroidBreak = false;
    		while (!stack.isEmpty()){
    			int last = stack.peekFirst();
    			if (last < 0){
    				break;
    			} else {
    				if (last + asteroid > 0){
    					newAsteroidBreak = true;
    					break;
    				} else if (last + asteroid == 0){
    					newAsteroidBreak = true;
    					stack.pollFirst();
    					break;
    				} else {
    					stack.pollFirst();
    				}
    			}
    		}
    		if (!newAsteroidBreak) stack.offerFirst(asteroid);
    	}
    	int[] res = new int[stack.size()];
    	for (int i = 0; i < res.length; i++){
    		res[i] = stack.pollLast();
    	}
    	return res;
    }
}

// Runtime: 5 ms, faster than 91.32% of Java online submissions for Asteroid Collision.
// Memory Usage: 40.1 MB, less than 83.96% of Java online submissions for Asteroid Collision.