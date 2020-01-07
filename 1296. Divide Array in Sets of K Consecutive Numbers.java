import java.util.Arrays;

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;
        if (len % k != 0) return false;
        Arrays.sort(nums);
        boolean[] visited = new boolean[len];
        int cur = 0;
        for (int i = 0; i < len / k; i++) {
            int next = -1;
            int curNum = nums[cur];
            visited[cur] = true;
            int count = 1;
            while (count < k) {
                cur++;
                if (visited[cur]) continue;
                if (nums[cur] > curNum + 1) return false;
                if (nums[cur] == curNum) {
                    if (next == -1) {
                        next = cur;
                    }
                } else {
                    visited[cur] = true;
                    curNum = nums[cur];
                    count++;
                }
            }
            if (next != -1) {
                cur = next;
            } else {
                cur++;
            }
        }
        return true;
    }
}

//ACC