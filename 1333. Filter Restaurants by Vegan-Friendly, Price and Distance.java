import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                if (restaurants[i1][1] > restaurants[i2][1]) return -1;
                else if (restaurants[i1][1] < restaurants[i2][1]) return 1;
                else return restaurants[i2][0] - restaurants[i1][0];
            }
        });
        for (int i = 0; i < restaurants.length; i++){
            int[] restaurant = restaurants[i];
            if (restaurant[2] >= veganFriendly && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                pq.offer(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(restaurants[pq.poll()][0]);
        }
        return res;
    }
}

// Runtime: 8 ms, faster than 72.52% of Java online submissions for Filter Restaurants by Vegan-Friendly, Price and Distance.
// Memory Usage: 56.2 MB, less than 100.00% of Java online submissions for Filter Restaurants by Vegan-Friendly, Price and Distance.