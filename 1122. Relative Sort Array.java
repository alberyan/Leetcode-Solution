class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len = arr2.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++){
            map.put(arr2[i], i);
        }
        Integer[] temp = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++){
            temp[i] = Integer.valueOf(arr1[i]);
        }
        Arrays.sort(temp, new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                int index1 = map.getOrDefault(i1, len);
                int index2 = map.getOrDefault(i2, len);
                if (index1 < len || index2 < len){
                    return index1 - index2;
                } else {
                    return i1 - i2;
                }
            }
        });
        for (int i = 0; i < arr1.length; i++){
            arr1[i] = temp[i];
        }
        return arr1;
    }
}

// Runtime: 4 ms, faster than 50.00% of Java online submissions for Relative Sort Array.
// Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Relative Sort Array.