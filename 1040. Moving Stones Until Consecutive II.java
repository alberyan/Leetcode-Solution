class Solution {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int len = stones.length;
        int max = stones[len - 1] - stones[0] + 1 - len;
        int min = 0;
        return new int[]{min, max};
    }
}
