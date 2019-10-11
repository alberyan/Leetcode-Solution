class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        for (char ch: s.toCharArray()){
        	if (ch != ')'){
        		stack.push(Character.toString(ch));
        	} else {
        		reverse(stack);
        	}
        }
       	StringBuilder sb = new StringBuilder();
       	while (!stack.isEmpty()){
       		sb.insert(0, stack.pop());
       	}
       	return sb.toString();
    }

    void reverse(Stack<String> stack){
    	StringBuilder sb = new StringBuilder();
    	while (!stack.isEmpty()){
    		String cur = stack.pop();
    		if (cur.equals("(")) break;
    		sb.insert(0, cur);
    	}
    	stack.push(sb.reverse().toString());
    }
}

//ACC