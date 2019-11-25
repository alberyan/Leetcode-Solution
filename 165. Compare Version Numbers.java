class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        for (int i = 0; i < Math.max(arr1.length, arr2.length); i++){
            int digit1 = i >= arr1.length ? 0 : Integer.parseInt(arr1[i]);
            int digit2 = i >= arr2.length ? 0 :Integer.parseInt(arr2[i]);
            if (digit1 > digit2) return 1;
            if (digit1 < digit2) return -1;
        }
        return 0;
    }
}

//ACC