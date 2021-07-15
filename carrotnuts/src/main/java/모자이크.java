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

        int re = solution(numPaper, heights, widths);
        System.out.println(re);
    }

    public static int solution(int numPaper, int[] heights, int[] widths) {

        // minimum paper size = max height
        int paperSize = Arrays.stream(heights).max().getAsInt();

        // sort widths(x)
        Arrays.sort(widths);

        while(true) {
            int remain = paperSize - 1;

            int cnt = 1;

            for (int i = 1; i < widths.length; i++) {
                remain -= widths[i] - widths[i - 1];
                if(remain < 0) {
                    cnt += 1;
                    remain = paperSize - 1;
                }
            }

            if (cnt <= numPaper) {
                break;
            }

            paperSize += 1;
        }

        return paperSize;
    }
}
