class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int[] dp = new int[len];
        int count = 0;
        if (nums[0] % 2 != 0){
            dp[0] = 1;
            map.put(1, 0);
            count = 1;
        }
        for (int i = 1; i < len; i++){
            if (nums[i] % 2 != 0){
                dp[i] = dp[i - 1] + 1;
                map.put(dp[i], i);
                count = dp[i];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        if (count < k) return 0;
        if (k == 1){
            if (count == 1){
                int index = map.get(1);
                return (index + 1) * (len - index);
            }
            int res = 0;
            res += (map.get(1) + 1) * (map.get(2) - map.get(1));
            res += (map.get(count) - map.get(count - 1)) * (len - map.get(count));
            for (int i = 2; i < count; i++){
                res += (map.get(i) - map.get(i - 1)) * (map.get(i + 1) - map.get(i));
            }
            return res;
        } else {
            if (count == k){
                return (map.get(1) + 1) * (len - map.get(count));
            }
            int res = 0;
            res += (map.get(1) + 1) * (map.get(k + 1) - map.get(k));
            res += (map.get(count - k + 1) - map.get(count - k)) * (len - map.get(count));
            for (int i = 2; i + k <= count; i++){
                res += (map.get(i) - map.get(i - 1)) * (map.get(i + k) - map.get(i + k - 1));
            }
            return res;
        }
    }
}

//ACC