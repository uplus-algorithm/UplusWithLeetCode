package main.java.LeetCode1011;

import java.util.Arrays;

public class Solution {
    // 컨베이어벨트는 패키지를 포트에서 다른 포트로 D일안에 운송해야한다.
    // 컨베이어벨트위의 i번째 패키지는 weight[i]의 무게를 가진다.
    // 배에 실을 수 있는 무게는 정해져있다.
    // D일 안에 모든 패키지를 운송하기 위한 최소 weight capacity를 구하라.
    public int shipWithinDays(int[] weights, int D) {

        int sum = Arrays.stream(weights).sum();

        int right = sum;
        int left = 0;

        while(left < right) {
            int mid = (left + right) / 2;

            if(check(weights, D, mid)) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean check(int[] weights, int D, int mid) {
        int cnt = 1;
        int sum = 0;

        int idx = 0;
        int len = weights.length;

        while(idx < len) {
            sum += weights[idx];

            if(sum > mid) {
                if(weights[idx] > mid) {
                    return false;
                }

                sum = 0;
                cnt += 1;
                continue;
            }

            idx += 1;
        }

        return cnt <= D;
    }
}