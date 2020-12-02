class Solution {
    public String reformatDate(String date) {
        Map<String, String> monthMap = new HashMap<>();
        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");
        String[] arr = date.split(" ");
        StringBuilder res = new StringBuilder();
        res.append(arr[2]);
        res.append("-");
        res.append(monthMap.get(arr[1]));
        res.append("-");
        if (arr[0].length() == 3) {
            res.append("0");
            res.append(arr[0].charAt(0));
        } else {
            res.append(arr[0].charAt(0));
            res.append(arr[0].charAt(1));
        }
        return res.toString();
    }
}

// Runtime: 2 ms, faster than 95.05% of Java online submissions for Reformat Date.
// Memory Usage: 39.3 MB, less than 100.00% of Java online submissions for Reformat Date.