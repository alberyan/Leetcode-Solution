class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new logComparator());
        return logs;
    }

    class logComparator implements Comparator<String>{
        public int compare(String s1, String s2){
            String[] arr1 = s1.split(" ");
            String[] arr2 = s2.split(" ");
            int index = 1;
            char ch1 = arr1[index].charAt(0);
            char ch2 = arr2[index].charAt(0);
            if (ch1 >= '0' && ch1 <= '9'){
                if (ch2 >= '0' && ch2 <= '9'){
                    return 0;
                } else {
                    return 1;
                }
            }
            if (ch2 >= '0' && ch2 <= '9'){
                return -1;
            }
            while (index < arr1.length && index < arr2.length){
                if (arr1[index].equals(arr2[index])){
                    index++;
                } else {
                    return arr1[index].compareTo(arr2[index]);
                }
            }
            return arr1.length < arr2.length ? -1 : 1;
        }
    }
}

// O(NlgN)
// Runtime: 10 ms, faster than 56.24% of Java online submissions for Reorder Log Files.
// Memory Usage: 40.5 MB, less than 15.68% of Java online submissions for Reorder Log Files.
