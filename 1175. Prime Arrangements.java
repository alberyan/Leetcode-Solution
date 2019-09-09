class Solution {
    public int numPrimeArrangements(int n) {
        boolean[] notPrime = new boolean[n + 1];
        notPrime[1] = true;
        for (int i = 2; i <= n; i++){
            for (int j = 2; i * j <= n; j++){
                notPrime[i * j] = true;
            }
        }
        double res = 1;
        int prime = 0;
        int nonPrime = 0;
        for (int i = 1; i <= n; i++){
            if (notPrime[i]){
                nonPrime++;
                res *= nonPrime;
            } else {
                prime++;
                res *= prime;
            }
            res %= 1000000007;
        }
        return (int)(res % 1000000007);
    }
}

//ACC