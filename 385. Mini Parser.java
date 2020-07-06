/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        Deque<NestedInteger> stack = new ArrayDeque<>();
        int index = 0;
        while (index < s.length){
            char ch = s.charAt(index);
            if (ch == '['){

            } else if (ch >= '0' && ch <= '9'){
                int num = 0;
                while (s.charAt(index) >= '0' && s.charAt(index) <= '9'){
                    num = num * 10 + s.charAt(index) - '0';
                    index++;
                }

                
            } else if (ch == ','){

            } else if (ch == ']'){

            }
        }
    }
}
