class Solution {
    public int flipLights(int n, int m) {
        Set<String> set = new HashSet<>();
        for (int a = 0; a <= 1; a++){
            for (int b = 0; b <= 1; b++){
                for (int c = 0; c <= 1; c++){
                    for (int d = 0; d <= 1; d++){
                        int sum = a + b + c + d - m;
                        if (sum <= 0 && sum % 2 == 0){
                            int[] arr = new int[n];
                            for (int i = 0; i < n; i++){
                                arr[i] += a;
                                if (i % 2 == 0) arr[i]+=b;
                                if (i % 2 == 1) arr[i]+=c;
                                if (i % 3 == 0) arr[i]+=d;
                                arr[i] %= 2;
                            }
                            set.add(Arrays.toString(arr));
                        }
                    }
                }
            }
        }
        return set.size();
    }
}


// Runtime: 9 ms, faster than 7.81% of Java online submissions for Bulb Switcher II.
// Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Bulb Switcher II.
