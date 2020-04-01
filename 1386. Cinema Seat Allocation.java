import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] reservedSeat: reservedSeats) {
            int row = reservedSeat[0];
            int seat = reservedSeat[1];
            Set<Integer> set = map.getOrDefault(row, new HashSet<>());
            set.add(seat);
            map.put(row, set);
        }
        int res = (n - map.keySet().size()) * 2;
        for (int row: map.keySet()) {
            Set<Integer> set = map.get(row);
            boolean leftLeftEmpty = !set.contains(2) && !set.contains(3);
            boolean leftCenterEmpty = !set.contains(4) && !set.contains(5);
            boolean rightCenterEmpty = !set.contains(6) && !set.contains(7);
            boolean rightRightEmpty = !set.contains(8) && !set.contains(9);
            if (leftLeftEmpty && leftCenterEmpty && rightCenterEmpty && rightRightEmpty) res += 2;
            else if (leftLeftEmpty && leftCenterEmpty) res++;
            else if (rightCenterEmpty && leftCenterEmpty) res++;
            else if (rightCenterEmpty && rightRightEmpty) res++;
        }
        return res;
    }
}

// Runtime: 31 ms, faster than 36.65% of Java online submissions for Cinema Seat Allocation.
// Memory Usage: 48.5 MB, less than 100.00% of Java online submissions for Cinema Seat Allocation.