package main.java.LeetCode986;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 각 리스트의 인터벌 start, end는 다르고, 정렬된 순서로 있다.
    // 두 리스트의 교집합을 구하여라
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> answer = new ArrayList<>();

        int idxFirst = 0;
        int idxSecond = 0;

        int firstLen = firstList.length;
        int secondLen = secondList.length;

        int min = 0;
        int max = 0;

        while (idxFirst < firstLen && idxSecond < secondLen) {
            int startFirst = firstList[idxFirst][0];
            int endFirst = firstList[idxFirst][1];

            int startSecond = secondList[idxSecond][0];
            int endSecond = secondList[idxSecond][1];

            min = Math.max(startFirst, startSecond);
            max = Math.min(endFirst, endSecond);

            // intersection exist
            if (min <= max) {
                int[] e = new int[2];
                e[0] = min;
                e[1] = max;
                answer.add(e);
            }

            // move next
            if (endFirst < endSecond) {
                idxFirst += 1;
            } else {
                idxSecond += 1;
            }
        }

        return answer.toArray(new int[0][0]);
    }

}
