class Solution {
    public double average(int[] salary) {
        int min = salary[0], max = salary[1];
        int total = 0;
        for (int s: salary) {
            min = Math.min(s, min);
            max = Math.max(s, max);
            total += s;
        }
        return (total - min - max - 0.0) / (salary.length - 2.0);
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Average Salary Excluding the Minimum and Maximum Salary.
// Memory Usage: 39.3 MB, less than 100.00% of Java online submissions for Average Salary Excluding the Minimum and Maximum Salary.