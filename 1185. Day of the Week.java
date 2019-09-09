class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int start = 4;
        for (int i = 1971; i < year; i++){
        	start += 365;
        	if (isRun(i)) start++;
        	start %= 7;
        }
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int m = 0; m < month - 1; m++){
        	start += months[m];
        }
        if (month > 2 && isRun(year)) start++;
        start += day;
        return days[start % 7];
    }

    boolean isRun(int year){
    	if (year % 400 == 0) return true;
    	if (year % 100 == 0) return false;
    	if (year % 4 == 0) return true;
    	return false;
    }
}

//ACC