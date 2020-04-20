import java.util.Map;

class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int digitSum = getDigitSum(i);
            map.put(digitSum, map.getOrDefault(digitSum, 0) + 1);
        }
        int max = 0;
        int res = 0;
        for (int val: map.values()) {
            if (val > max) {
                res = 1;
                max = val;
            }
            else if (val == max) {
                res++;
            }
        }
        return res;
    }

    private int getDigitSum(int n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}

// Runtime: 11 ms, faster than 46.82% of Java online submissions for Count Largest Group.
// Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for Count Largest Group.