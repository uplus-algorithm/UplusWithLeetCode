package leetcode1769;
import java.util.*;


public class Main {

    static int[] answer;
    static int[] toRight;
    static int[] toLeft;
    public static void main(String[] args) {
        String temp = "001011";
        System.out.println(minOperations(temp).toString());

    }

    public static int[] minOperations(String boxes) {
        answer = new int[boxes.length()];
        toLeft = new int[boxes.length()];
        toRight = new int[boxes.length()];

        Arrays.fill(answer, 0);
        Arrays.fill(toLeft, 0);
        Arrays.fill(toRight, 0);

        int cnt = 0;
        for(int i = 0; i < boxes.length(); i++) {
            if(i != 0) {
                toRight[i] = cnt + toRight[i-1];
            }
            if(boxes.charAt(i) == '1') {
                cnt++;
            }
            answer[i] += toRight[i];
        }
        cnt = 0;
        for(int i = boxes.length()-1; i >= 0; i--) {
            if(i != boxes.length() -1) {
                toLeft[i] = cnt + toLeft[i+1];
            }
            if(boxes.charAt(i) == '1') {
                cnt++;
            }
            answer[i] += toLeft[i];
        }


        return answer;
    }
}
