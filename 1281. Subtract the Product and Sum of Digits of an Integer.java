class Solution {
    public int subtractProductAndSum(int n) {
        if (n == 0) return 0;
        int product = 1;
        int sum = 0;
        while (n > 0){
            int digit = n % 10;
            n /= 10;
            product *= digit;
            sum += digit;
        }
        return product - sum;
    }
}

//Acc