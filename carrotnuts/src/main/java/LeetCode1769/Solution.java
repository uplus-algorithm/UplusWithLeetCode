package main.java.LeetCode1769;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // n개의 박스
    // i번째 박스의 값이 0이면 비었고, 1이면 하나의 공이 있다.
    // 한 번에 인접 박스로 공을 옮길 수 있다.
    // 1개 이상의 공을 가진 박스가 있을 수 있다.

    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];
        List<Integer> idxList = new ArrayList<>();

        for(int i=0; i<boxes.length(); i++) {
            char c = boxes.charAt(i);
            if(c == '1')
                idxList.add(i);
        }

        for(int i=0; i<boxes.length(); i++) {
            int cnt = 0;
            for(int e : idxList) {
                cnt += Math.abs(i - e);
            }
            ans[i] = cnt;
        }

        return ans;
    }
}
