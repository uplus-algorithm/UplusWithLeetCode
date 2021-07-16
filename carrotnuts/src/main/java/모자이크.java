package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 모자이크 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().trim().split(" ");
        int maxHeight = Integer.parseInt(split[0]);
        int maxWidth = Integer.parseInt(split[1]);

        int numPaper = Integer.parseInt(br.readLine().trim());
        int len = Integer.parseInt(br.readLine().trim());

        int[] heights = new int[len];
        int[] widths = new int[len];
        for (int i = 0; i < len; i++) {
            split = br.readLine().trim().split(" ");
            heights[i] = Integer.parseInt(split[0]);
            widths[i] = Integer.parseInt(split[1]);
        }

        int re = solution(numPaper, maxWidth, heights, widths);
        System.out.println(re);
    }

    public static int solution(int numPaper, int maxWidth, int[] heights, int[] widths) {

        // minimum paper size = max height
        int left = Arrays.stream(heights).max().getAsInt();
        int right = maxWidth;

        // sort widths(x)
        Arrays.sort(widths);

        // binary search
        while(left < right) {

            // 색종이 크기
            int mid = (left + right) / 2;

            int remain = mid - 1;
            int cnt = 1;
            for (int i = 1; i < widths.length; i++) {
                int gap = widths[i] - widths[i - 1];
                remain -= gap;

                if(remain < 0) {
                    cnt += 1;
                    remain = mid - 1;
                }
            }

            if (cnt <= numPaper) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }
}
