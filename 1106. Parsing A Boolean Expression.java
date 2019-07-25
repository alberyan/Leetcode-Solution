class Solution {
    public boolean parseBoolExpr(String expression) {
    	if (expression.equals("t")) return true;
    	if (expression.equals("f")) return false;
        Deque<Character> symbolstack = new ArrayDeque<>();
        Deque<Character> valueStack = new ArrayDeque<>();
        for (char ch: expression.toCharArray()){
        	if (ch == ',') continue;
        	if (ch == '|' || ch == '&' || ch == '!'){
        		symbolstack.offerFirst(ch);
        	} else if (ch == '(' || ch =='t' || ch == 'f') {
        		valueStack.offerFirst(ch);
        	} else {
        		char symbol = symbolstack.pollFirst();
        		if (symbol == '&'){
        			char flag = 't';
        			while (!valueStack.isEmpty()){
        				char cur = valueStack.pollFirst();
        				if (cur == '(') break;
        				else if (cur == 'f') flag = 'f';
        			}
        			valueStack.offerFirst(flag);
        		} else if (symbol == '|'){
        			char flag = 'f';
        			while (!valueStack.isEmpty()){
        				char cur = valueStack.pollFirst();
        				if (cur == '(') break;
        				else if (cur == 't') flag = 't';
        			}
        			valueStack.offerFirst(flag);
        		} else {
        			char cur = valueStack.pollFirst();
        			valueStack.pollFirst();
        			valueStack.offerFirst(cur == 't' ? 'f' : 't');
        		}
        	}
        }
        return valueStack.pollFirst() == 't';
    }
}

//O(n)
// Runtime: 11 ms, faster than 52.15% of Java online submissions for Parsing A Boolean Expression.
// Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Parsing A Boolean Expression.