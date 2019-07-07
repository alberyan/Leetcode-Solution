class Solution {
    public String defangIPaddr(String address) {
        String[] arr = address.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++){
            sb.append(arr[i]);
            sb.append("[.]");
        }
        sb.append(arr[arr.length - 1]);
        return sb.toString();
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Defanging an IP Address.
// Memory Usage: 34.1 MB, less than 100.00% of Java online submissions for Defanging an IP Address.