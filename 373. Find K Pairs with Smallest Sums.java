class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        k = Math.min(nums1.length * nums2.length, k);
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> (b[0] + b[1]) - (a[0] + a[1]));
        int maxIndex1 = Math.min(nums1.length - 1, k - 1);
        int maxIndex2 = Math.min(nums2.length - 1, k - 1);
        for (int i = 0; i <= maxIndex1; i++){
            for (int j = 0; j <= maxIndex2; j++){
                int newSum = nums1[i] + nums2[j];
                if (pq.size() < k){
                    pq.offer(new int[]{nums1[i], nums2[j]});
                } else {
                    int[] origin = pq.peek();
                    if (origin[0] + origin[1] <= newSum){
                        maxIndex2 = j;
                        break;
                    } else {
                        pq.poll();
                        pq.offer(new int[]{nums1[i], nums2[j]});
                    }
                }
            }
        }
        List<int[]> res = new ArrayList<>();
        while (!pq.isEmpty()){
            res.add(pq.poll());
        }
        return res;
    }
}

// Runtime: 38 ms, faster than 40.55% of Java online submissions for Find K Pairs with Smallest Sums.
// Memory Usage: 37.7 MB, less than 96.77% of Java online submissions for Find K Pairs with Smallest Sums.
