class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        int[][] arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i] = new int[]{intervals[i][0], i};
        }
        Arrays.sort(arr, (int[] i1, int[] i2) -> (i1[0] - i2[0]));
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int end = intervals[i][1];
            for (int j = 0; j < len; j++) {
                if (end <= arr[j][0]) {
                    res[i] = arr[j][1];
                    break;
                }
                res[i] = -1;
            }
        }
        return res;
    }
}

// ACC