package backjoon;
/*
 * 백준 - 오름세(3745번)
 * version 1.0
 * 2021.07.09
 * Copyright (c) by Davinci.J
 */
import java.util.Scanner;

public class Backjoon3745 {

    public static void main(String[] args) {
        Backjoon3745 main = new Backjoon3745();
        main.processCommand();
    }

    private final Scanner scanner = new Scanner(System.in);

    public void processCommand() {
        while (scanner.hasNext()) {
            int sequenceSize = scanner.nextInt();
            int[] sequence = initialSequence(sequenceSize);
            int[] dp = new int[sequenceSize];

            System.out.println(getLongestIncreasingSubsequence(sequenceSize, sequence, dp));
        }
        scanner.close();
    }

    private int[] initialSequence(int sequenceSize) {
        int[] sequence = new int[sequenceSize];
        for (int i=0; i<sequenceSize; i++) {
            sequence[i] = Integer.parseInt(scanner.next());
        }
        return sequence;
    }

    private int getLongestIncreasingSubsequence(int sequenceSize, int[] sequence, int[] dp) {
        dp[0] = sequence[0];
        int dpSize = 1;
        for (int i=1; i<sequenceSize; i++) {
            if (dp[dpSize - 1] < sequence[i]) {
                dp[dpSize] = sequence[i];
                dpSize++;
            } else {
                int insertedIndex = getIndexByBinarySearch(dp, sequence[i], 0, dpSize - 1);
                dp[insertedIndex] = sequence[i];
            }
        }
        return dpSize;
    }

    private int getIndexByBinarySearch(int[] dp, int sequenceNumber, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return startIndex;
        }
        int midIndex = (startIndex + endIndex) / 2;
        if (dp[midIndex] < sequenceNumber) {
            startIndex = midIndex + 1;
        } else {
            endIndex = midIndex;
        }
        return getIndexByBinarySearch(dp, sequenceNumber, startIndex, endIndex);
    }
}
