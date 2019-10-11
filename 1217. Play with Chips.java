class Solution {
    public int minCostToMoveChips(int[] chips) {
        int oddCount = 0;
        for (int chip: chips){
        	if (chip % 2 == 1) oddCount++;
        }
        return Math.min(chips.length - oddCount, oddCount);
    }
}

//ACC