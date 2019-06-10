class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();
        String[] arr = text.split(" ");
        for (int i = 0; i < arr.length - 2; i++){
            if (arr[i].equals(first) && arr[i + 1].equals(second)){
            	list.add(arr[i + 2]);
            }
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++){
        	res[i] = list.get(i);
        }
        return res;
    }
}

// Runtime: 1 ms, faster than 95.69% of Java online submissions for Occurrences After Bigram.
// Memory Usage: 34.5 MB, less than 100.00% of Java online submissions for Occurrences After Bigram.