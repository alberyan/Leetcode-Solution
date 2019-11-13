class Solution {
    public List<Integer> transformArray(int[] arr) {
        int len = arr.length;
        boolean hasChange = true;
        while (hasChange) {
            hasChange = false;
            int[] next = new int[len];
            next[0] = arr[0];
            next[len - 1] = arr[len - 1];
            for (int i = 1; i < len - 1; i++){
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]){
                    next[i] = arr[i] - 1;
                    hasChange = true;
                } else if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]){
                    next[i] = arr[i] + 1;
                    hasChange = true;
                } else {
                    next[i] = arr[i];
                }
            }
            arr = next;
        }
        List<Integer> res = new ArrayList<>();
        for (int i: arr){
            res.add(i);
        }
        return res;
    }
}

//Acc