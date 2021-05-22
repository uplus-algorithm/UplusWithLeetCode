package main.java.LeetCode921;

import java.util.Stack;

public class Solution {
    public int minAddToMakeValid(String s) {
        // empty string
        // AB, A AND B is valid
        // (A), A is valid

        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        int answer = 0;
        for(int i=0; i<s.length(); i++) {
            if(charArray[i] == ')') {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
                else {
                    answer += 1;
                }
            }
            else {
                stack.add(charArray[i]);
            }
        }

        return stack.size() + answer;
    }
}
