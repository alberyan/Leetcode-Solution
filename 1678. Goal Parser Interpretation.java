class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        while (command.length() > 0) {
            if (command.startsWith("G")) {
                sb.append("G");
                command = command.substring(1);
            }
            if (command.startsWith("()")) {
                sb.append("o");
                command = command.substring(2);
            }
            if (command.startsWith("(al)")) {
                sb.append("al");
                command = command.substring(4);
            }
        }
        return sb.toString();
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Goal Parser Interpretation.
// Memory Usage: 37.3 MB, less than 75.00% of Java online submissions for Goal Parser Interpretation.