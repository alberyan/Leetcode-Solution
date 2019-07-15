class PhoneDirectory {

    Set<Integer> used;
    Set<Integer> available;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        used = new HashSet<>();
        available = new HashSet<>();
        for (int i = 0; i < maxNumbers; i++){
            available.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (available.size() == 0) return -1;
        for (int i: available){
            available.remove(i);
            used.add(i);
            return i;
        }
        return -1;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return available.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        available.add(number);
        used.remove(number);
    }
}

// Runtime: 79 ms, faster than 12.22% of Java online submissions for Design Phone Directory.
// Memory Usage: 43.8 MB, less than 11.14% of Java online submissions for Design Phone Directory.

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */