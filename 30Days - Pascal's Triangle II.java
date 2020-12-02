class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            res.add(com(rowIndex, i));
        }
        return res;
    }
    
    private int com(int a, int b) {
        long res = 1;
        for (int i = b + 1; i <= a; i++) {
            res *= i;
            res /= i - b;
        }
        return (int)res;
    }
}

// ACC