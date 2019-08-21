class Solution {
    public int dayOfYear(String date) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] arr = date.split("-");
        int year = Integer.parseInt(arr[0]);
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) days[2] = 29;
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        for (int i = 0; i < month; i++){
            day += days[i];
        }
        return day;
    }
}

//ACC