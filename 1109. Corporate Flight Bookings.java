class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] booking: bookings){
        	int start = booking[0];
        	int end = booking[1];
        	int seats = booking[2];
        	for (int i = start; i <= end; i++){
        		res[i - 1] += seats;
        	}
        }
        return res;
    }
}

// Runtime: 626 ms, faster than 100.00% of Java online submissions for Corporate Flight Bookings.
// Memory Usage: 76.3 MB, less than 100.00% of Java online submissions for Corporate Flight Bookings.

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
      int[] res = new int[n];
      for (int[] v : bookings) {
        res[v[0] - 1] += v[2];
        if (v[1] < n) res[v[1]] -= v[2];
      }
      for (int i = 1; i < n; ++i) res[i] += res[i - 1];
      return res;
    }
}

// Runtime: 3 ms, faster than 100.00% of Java online submissions for Corporate Flight Bookings.
// Memory Usage: 66.2 MB, less than 100.00% of Java online submissions for Corporate Flight Bookings.
