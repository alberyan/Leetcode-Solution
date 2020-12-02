class SolutionTLE {
    public int numSubseq(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
        int lastIndex = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target / 2) break;
            int j = getJ(i, lastIndex, nums, target);
            res += getCombination(j - i);
            res %= 1000000007;
            lastIndex = j;
        }
        return res % 1000000007;
    }

    private int getCombination(int i) {
        int res = 1;
        while (i-- > 0) {
            res <<= 1;
            res %= 1000000007;
        }
        return res;
    }

    private int getJ(int i, int lastIndex, int[] nums, int target) {
        if (lastIndex == i) return lastIndex;
        if (nums[i] + nums[lastIndex] <= target) return lastIndex;
        int start = i;
        int end = lastIndex;
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (nums[i] + nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }
}

