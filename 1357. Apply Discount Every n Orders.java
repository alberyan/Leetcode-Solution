class Cashier {
    Map<Integer, Integer> productMap = new HashMap<>();
    int count;
    int discount;
    int n;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        count = 0;
        this.discount = discount;
        for (int i = 0; i < products.length; i++) {
            productMap.put(products[i], prices[i]);
        }
    }
    
    public double getBill(int[] product, int[] amount) {
        double total = 0.0;
        for (int i = 0; i < product.length; i++) {
            total += amount[i] * productMap.get(product[i]);
        }
        if (++count == n) {
            total = total * (100 - discount) / 100;
            count = 0;
        }
        return total;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */

// Runtime: 108 ms, faster than 48.75% of Java online submissions for Apply Discount Every n Orders.
// Memory Usage: 63.6 MB, less than 100.00% of Java online submissions for Apply Discount Every n Orders.