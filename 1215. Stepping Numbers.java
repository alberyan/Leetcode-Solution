class Solution {
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for (int i = low; i <= high; i++){
        	if (isSteppingNumber(i)){
        		res.add(i);
        	}
        }
        return res;
    }

    boolean isSteppingNumber(int number){
    	int cur = number % 10;
    	number = number / 10;
    	while (number > 0){
    		int next = number % 10;
    		number = number / 10;
    		if (Math.abs(cur - next) != 1) return false;
    		cur = next;
    	}
    	return true;
    }
}

// TLE

class Solution {
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> res = new ArrayList<>();
    }

    
}