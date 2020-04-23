import java.time.LocalDate;
import java.time.temporal.*;

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs((int)(ChronoUnit.DAYS.between(LocalDate.parse(date2), LocalDate.parse(date1))));
    }
}

// Runtime: 8 ms, faster than 40.44% of Java online submissions for Number of Days Between Two Dates.
// Memory Usage: 38.4 MB, less than 100.00% of Java online submissions for Number of Days Between Two Dates.

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysSince1970(date2) - daysSince1970(date1));
    }
    
    private int daysSince1970(String date) {
        int year = Integer.parseInt(date.split("-")[0]);
        int month = Integer.parseInt(date.split("-")[1]);
        int day = Integer.parseInt(date.split("-")[2]);
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int res = 0;
        for (int y = 1970; y < year; y++) {
            if (isRun(y)) res += 366;
            else res += 365;
        }
        for (int m = 0; m < month - 1; m++){
            if (m == 1 && isRun(year)) res += 29;
            else res += days[m];
        }
        return res + day - 1;   
    }
    
    private boolean isRun(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        if (year % 4 == 0) return true;
        return false;
    }
}

// Runtime: 1 ms, faster than 96.90% of Java online submissions for Number of Days Between Two Dates.
// Memory Usage: 37.8 MB, less than 100.00% of Java online submissions for Number of Days Between Two Dates.