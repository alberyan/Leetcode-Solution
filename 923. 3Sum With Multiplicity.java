class Solution {
    public int threeSumMulti(int[] A, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: A){
            if (i > target) continue;
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int res = 0;
        if (target % 3 == 0){
            int count = map.getOrDefault(target / 3, 0);
            res += cal(count, 3);
        }
        for (int i = 0; i <= target / 2; i++){
            int j = target - 2 * i;
            int countI = map.getOrDefault(i, 0);
            int countJ = map.getOrDefault(j, 0);
            if (i != j){
                res += cal(countI, 2) * countJ;
            }
        }
        for (int i = 0; i <= target; i++){
            int countI = map.getOrDefault(i, 0);
            if (countI == 0) continue;
            for (int j = i + 1; i + j <= target; j++){
                int countJ = map.getOrDefault(j, 0);
                if (countJ == 0) continue;
                int k = target - i - j;
                int countK = map.getOrDefault(k, 0);
                if (k <= j) break;
                res += countI * countJ * countK;
            }
        }
        return res;
    }


    double cal(int a, int b){
        if (a < b) return 0;
        double res = 1;
        for (int i = 1; i <= b; i++){
            res *= (a + 1 - i);
            res /= i;
        }
        return (int)(res % (1000000007));
    }
}

// Runtime: 9 ms, faster than 70.19% of Java online submissions for 3Sum With Multiplicity.
// Memory Usage: 39.6 MB, less than 47.06% of Java online submissions for 3Sum With Multiplicity.
