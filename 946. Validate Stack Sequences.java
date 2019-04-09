class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pushed.length; i++){
            map.put(pushed[i], i);
        }
        for (int i = 0; i < popped.length; i++){
            popped[i] = map.get(popped[i]);
        }
        for (int i = 0; i < popped.length; i++){
            for (int j = i + 1; j < popped.length; j++){
                if (popped[i] > popped[j]){
                    for (int k = j + 1; k < popped.length; k++){
                        if (popped[i] > popped[k] && popped[k] > popped[j]) return false;
                    }
                }
            }
        }
        return true;
    }
}

//O(N^3)
// Runtime: 33 ms, faster than 5.99% of Java online submissions for Validate Stack Sequences.
// Memory Usage: 40.9 MB, less than 72.55% of Java online submissions for Validate Stack Sequences.



// Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.
//
// Example 1:
//
// Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
// Output: true
// Explanation: We might do the following sequence:
// push(1), push(2), push(3), push(4), pop() -> 4,
// push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
// Example 2:
//
// Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
// Output: false
// Explanation: 1 cannot be popped before 2.
//
//
// Note:
//
// 0 <= pushed.length == popped.length <= 1000
// 0 <= pushed[i], popped[i] < 1000
// pushed is a permutation of popped.
// pushed and popped have distinct values.
