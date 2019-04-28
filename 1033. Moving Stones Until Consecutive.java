class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        a = arr[0];
        b = arr[1];
        c = arr[2];
        int min = (b - a == 1 ? 0: 1) + (c - b == 1 ? 0: 1);
        if (b - a == 2 || c - b == 2) min = 1;
        int max = c - a - 2;
        return new int[]{min, max};
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Moving Stones Until Consecutive.
// Memory Usage: 33.1 MB, less than 100.00% of Java online submissions for Moving Stones Until Consecutive.
