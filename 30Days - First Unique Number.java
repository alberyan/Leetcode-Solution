class FirstUnique {

    Queue<Integer> queue;
    Map<Integer, Integer> numCount;
    public FirstUnique(int[] nums) {
        queue = new LinkedList<>();
        numCount = new HashMap<>();
        for (int num: nums) {
            queue.offer(num);
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
    }
    
    public int showFirstUnique() {
        while (!queue.isEmpty()) {
            int cur = queue.peek();
            if (numCount.get(cur) == 1) return cur;
            queue.poll();
        }
        return -1;
    }
    
    public void add(int value) {
        queue.offer(value);
        numCount.put(value, numCount.getOrDefault(value, 0) + 1);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */