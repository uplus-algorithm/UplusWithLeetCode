package main.java.LeetCode1491;

import java.util.Arrays;

public class Solution {
    public double average(int[] salary) {
        double avg = Arrays.stream(salary)
                .sorted()
                .skip(1)
                .limit(salary.length - 2)
                .average()
                .getAsDouble();

        return avg;
    }
}
