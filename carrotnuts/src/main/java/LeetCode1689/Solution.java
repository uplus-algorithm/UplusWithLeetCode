package main.java.LeetCode1689;

public class Solution {
    // deci-binary -> 0과 1로만 이루어진
    // 주어진 수 n을 deci-binary의 합으로 만들어라,
    // 이때 필요한 deci-binary를 최소로 해라.
    public int minPartitions(String n) {
        char[] characters = n.toCharArray();

        int max = 0;
        for(char c : characters) {
            int num = c - '0';
            max = Math.max(max, num);
        }

        return max;
    }
}
