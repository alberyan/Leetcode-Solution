import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution1 {
    public List<String> printVertically(String s) {
        String[] arr = s.split(" ");
        Queue<String> q = new LinkedList<>();
        int maxLength = 0;
        for (String str: arr) {
            maxLength = Math.max(maxLength, str.length());
            q.offer(str);
        }
        List<String> res = new ArrayList<>();
        int size = q.size();
        for (int j = 0; j < maxLength; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++){
                String cur = q.poll();
                if (cur.isEmpty()) {
                    sb.append(' ');
                    q.offer(cur);
                } else {
                    sb.append(cur.charAt(0));
                    q.offer(cur.substring(1));
                }
            }
            while (sb.length() > 0) {
                if (sb.charAt(sb.length() - 1) == ' '){
                    sb.setLength(sb.length() - 1);
                }
                else {
                    break;
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
}

// Runtime: 3 ms, faster than 43.15% of Java online submissions for Print Words Vertically.
// Memory Usage: 42.6 MB, less than 100.00% of Java online submissions for Print Words Vertically.

class Solution {
    public List<String> printVertically(String s) {
        String[] arr = s.split(" ");
        int len = arr.length;
        int maxLength = 0;
        int[] dp = new int[len];
        dp[len - 1] = arr[len - 1].length();
        for (int i = len - 2; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], arr[i].length());
        }
        maxLength = dp[0];
        List<String> res = new ArrayList<>();
        for (int j = 0; j < maxLength; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++){
                if (j >= dp[i]) break;
                if (j >= arr[i].length()) sb.append(' ');
                else sb.append(arr[i].charAt(j));
            }
            res.add(sb.toString());
        }
        return res;
    }
}

// Runtime: 1 ms, faster than 85.42% of Java online submissions for Print Words Vertically.
// Memory Usage: 42 MB, less than 100.00% of Java online submissions for Print Words Vertically.